package cn.suqc.controller;

import cn.suqc.util.ApplicationConstants;
import javafx.application.Application;
import org.omg.CORBA.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

@Controller
public class PageController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/{page}")
    public String goToPage(@PathVariable String page, HttpServletRequest request, HttpServletResponse response){

        return page;
    }
}
