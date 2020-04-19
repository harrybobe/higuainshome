package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.intface.IUserService;
import com.example.demo.utils.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DemoController {

    @Resource
    private IUserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return userService.get("abc").toString();
    }

    @RequestMapping("/export")
    public void export(HttpServletRequest request){
        String filePath = "C:\\bobospace\\测试.xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("111","222","333"));
        data.add(Arrays.asList("111","222","333"));
        data.add(Arrays.asList("111","222","333"));
        List<String> head = Arrays.asList("表头1", "表头2", "表头3");
        ExcelUtil.writeBySimple(filePath,data,head);
    }
}
