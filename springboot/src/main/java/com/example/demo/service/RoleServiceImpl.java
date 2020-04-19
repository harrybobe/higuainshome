package com.example.demo.service;

import com.example.demo.intface.IRoleService;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class RoleServiceImpl implements IRoleService {

    @Override
    public String getRole(String userName) {
        return "master";
    }
}
