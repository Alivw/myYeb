package com.awei.server.service.impl;

import com.awei.server.pojo.Admin;
import com.awei.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Description: 自定义登录逻辑
 * @Author: Awei
 * @Create: 2021-03-09 21:51
 **/
@Service("myUserDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IAdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = adminService.getAdminByUsername(s);
        if (null != admin) {
            return admin;
        }
        return null;
    }
}
