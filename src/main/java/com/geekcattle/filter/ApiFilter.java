package com.geekcattle.filter;

import com.geekcattle.util.JsonUtil;
import com.geekcattle.util.ReturnUtil;
import com.geekcattle.core.jwt.JwtConfig;
import com.geekcattle.core.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ServletComponentScan
//@WebFilter(filterName = "apiFilter", urlPatterns = "/api/member/*")
@WebFilter(filterName = "apiFilter", urlPatterns = "/api/oauth/*")
public class ApiFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private JwtUtil jwtUtil;

    //这里是排除验证链接
    private String[] excludeURLs = new String[]{"/api/oauth/admintoken"};

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        //排除无须验证的链接
        String uri = request.getRequestURI();
        for (String excludeURL : excludeURLs) {
            if (uri.contains(excludeURL)) {
                chain.doFilter(request, response);
                return;
            }
        }

        //获取前端传过来的token
        String auth = request.getParameter("token");
        if ((auth != null) && (auth.length() > 7)) {
            Claims claims = jwtUtil.parseJWT(auth, jwtConfig.getSecret());
            if (claims != null) {
                String userId = claims.getId();
                String userName = claims.getSubject();
                String sessionId = claims.getAudience();
                request.setAttribute("userId", userId);
                request.setAttribute("userName", userName);
                CustomHttpServletRequest customHttpServletRequest = new CustomHttpServletRequest(request);
                customHttpServletRequest.putHeader("Cookie", "WEBID=" + sessionId);
                chain.doFilter(customHttpServletRequest, response);
                return;
            }
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(JsonUtil.toJson(ReturnUtil.Error("TOKEN验证失败")));
        return;
    }
}
