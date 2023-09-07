package com.cydeo.spring07springmvccontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String user(){

        return "/user/userinfo.html";  //go to folder static and look overthere -static folder is a default starter folder
    }

}
