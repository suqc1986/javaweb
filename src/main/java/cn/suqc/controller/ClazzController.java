package cn.suqc.controller;

import cn.suqc.dao.ClazzDao;
import cn.suqc.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    ClazzDao clazzDao;

    @RequestMapping("/getClazz1/{id}")
    @ResponseBody
    public Clazz getClazzById1(@PathVariable int id){
        return clazzDao.queryClassById1(id);
    }

    @RequestMapping("/getClazz2/{id}")
    @ResponseBody
    public Clazz getClazzById2(@PathVariable int id){
        return clazzDao.queryClassById2(id);
    }
}
