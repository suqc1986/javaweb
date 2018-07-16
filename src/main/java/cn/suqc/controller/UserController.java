package cn.suqc.controller;

import cn.suqc.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/getAge2Cnt")
    @Cacheable(value="dataCache",key="#root.methodName")
    @ResponseBody
    public List<Map<Integer,Integer>> getAge2Cnt(HttpServletResponse response) throws Exception{
        return userService.getAge2Cnt();
    }
}
