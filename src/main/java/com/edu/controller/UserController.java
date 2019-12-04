package com.edu.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edu.entity.Result;
import com.edu.entity.User;
import com.edu.service.UserService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @PostMapping("/register")
    public Result addUser(User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/toupload")
    public String toupload() {
        return "upload";
    }

    @ResponseBody
    @RequestMapping("/downloadExcelTemplate")
    public Result downloadExcelTemplate(HttpServletResponse response) {
        return userService.downloadExcelTemplate(response);
    }
    @ResponseBody
    @RequestMapping("/import")
    public Result importExcel(@RequestParam(value = "filename") MultipartFile file) {
        return userService.importExcel(file);
    }
    @ResponseBody
    @RequestMapping("/export")
    public Result exportExcel(HttpServletResponse response) {
        return userService.exportExcel(response);
    }
}