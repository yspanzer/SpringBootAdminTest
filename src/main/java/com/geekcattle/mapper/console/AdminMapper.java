/*
 * Copyright (c) 2017 <l_iupeiyu@qq.com> All rights reserved.
 */

package com.geekcattle.mapper.console;

import com.geekcattle.model.Region;
import com.geekcattle.model.console.Admin;
import com.geekcattle.util.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * author geekcattle
 * date 2016/10/21 0021 下午 15:32
 */
@Service
public interface AdminMapper extends CustomerMapper<Admin> {
    Admin selectByUsername(String username);
    void deleteById(String Id);
    Region getRegionByUserID(String uid);
}
