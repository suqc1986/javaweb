package cn.suqc.controller;

import cn.suqc.dao.AllDao;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/all")
public class AllController {
    @Autowired
    private AllDao allDao;
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Map<String,String>> getAll(){
        PageBounds pb = new PageBounds(1,2,Order.create("birthdate","desc"));
        return allDao.getAll(null,pb);
    }
}
