package com.example.demo.service;

import com.example.demo.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticMethods.class})
public class UserServiceImplTest {

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private RoleServiceImpl roleService;

    @Test
    public void test(){
        PowerMockito.mockStatic(StaticMethods.class);
        PowerMockito.when(StaticMethods.getUserGrage()).thenReturn("bobotest2");
        PowerMockito.when(roleService.getRole(Mockito.any())).thenReturn("bobotest");

        User user = userService.get("123456");
        System.out.println(user);

    }
}