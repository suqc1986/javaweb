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
