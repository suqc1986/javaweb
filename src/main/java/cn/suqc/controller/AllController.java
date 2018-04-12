package cn.suqc.controller;

import cn.suqc.dao.AllDao;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/all")
public class AllController {
    @Autowired
    private AllDao allDao;
    @RequestMapping("/getAllList2")
    @ResponseBody
    public Map<String,Integer> getAllList2(HttpServletRequest request) throws Exception{
        Integer page = null;
        Integer pageSize = null;
        try {
            page = Integer.parseInt(request.getParameter("page"));
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        } catch (NumberFormatException e) {
            page = 1;
            pageSize = 10;
        }
        PageBounds pb = new PageBounds(page,pageSize);
        Map<String,Integer> newMap = new HashMap<String,Integer>();
        List<Map<String, String>> list = allDao.getAllList2(null,new PageBounds(page,pageSize));
        for(Map<String,String> map:list){
            newMap.put(map.get("code").toString(), Integer.parseInt(map.get("cnt")));//map.get("cnt").toString() 就会报错  Long->String 不知道为啥
        }
        return newMap;
    }


    @RequestMapping("/getAllList")
    @ResponseBody
    public List<Map<String,String>> getAllList(HttpServletRequest request) throws Exception{
        Integer page = null;
        Integer pageSize = null;
        try {
            page = Integer.parseInt(request.getParameter("page"));
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        } catch (NumberFormatException e) {
            page = 1;
            pageSize = 10;
        }
        PageBounds pb = new PageBounds(page,pageSize,Order.create("birthdate","desc"));
        return allDao.getAllList(null,pb);
    }
    @RequestMapping("/getAllMap")
    @ResponseBody
    public Map<String,Map<String,String>> getAllMap(HttpServletRequest request) throws Exception{
        Integer page = null;
        Integer pageSize = null;
        try {
            page = Integer.parseInt(request.getParameter("page"));
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        } catch (NumberFormatException e) {
            page = 1;
            pageSize = 10;
        }
        PageBounds pb = new PageBounds(page,pageSize,Order.create("birthdate","desc"));
        return allDao.getAllMap(null,pb);
    }
}
