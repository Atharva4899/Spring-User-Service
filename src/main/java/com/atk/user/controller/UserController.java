package com.atk.user.controller;

import com.atk.user.VO.ResponseTemplate;
import com.atk.user.entity.SysUser;
import com.atk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public SysUser saveUser(@RequestBody SysUser sysUser){
        return userService.saveUser(sysUser);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getUserByDepartment(@PathVariable("id") Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
