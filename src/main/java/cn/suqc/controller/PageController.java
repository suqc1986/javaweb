package cn.suqc.controller;

import cn.suqc.service.SpringServiceManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class PageController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/{page}")
    public String goToPage(@PathVariable String page, HttpServletRequest request, HttpServletResponse response){
        //System.out.println(SpringServiceManager.getApplicationContext());
        return page;
    }
}
