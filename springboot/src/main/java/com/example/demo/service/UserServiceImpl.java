package com.example.demo.service;

import com.example.demo.common.RoleEnum;
import com.example.demo.domain.User;
import com.example.demo.intface.IRoleService;
import com.example.demo.intface.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceImpl implements IUserService{

    Logger logger= LogManager.getLogger(this.getClass());

    @Resource
    private IRoleService roleService;

    @Override
    public User get(String id) {
        logger.info("test.");
        String role = roleService.getRole("abc");
        User user = User.builder()
                .userName("abc")
                .passWord("123456")
                .role(role)
                .grade(StaticMethods.getUserGrage())
                .build();

       RoleEnum roleEnum = RoleEnum.getRoleEnumByKey("teacher");
       if (roleEnum != null){
           System.out.println(roleEnum.getValue());
           switch (roleEnum){
               case MASTER:
                   System.out.println(RoleEnum.MASTER.getValue());
                   break;
               case TEACHER:
                   System.out.println(RoleEnum.TEACHER.getValue());
                   break;
               default:
                   break;
           }
       }


       return user;
    };

}
