package cn.suqc.controller;

import cn.suqc.dao.AreasDao;
import cn.suqc.dao.CitiesDao;
import cn.suqc.dao.ProvincesDao;
import cn.suqc.entity.Areas;
import cn.suqc.entity.Cities;
import cn.suqc.entity.PCAInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pca")
public class PcaAssController {
    @Resource
    ProvincesDao provincesDao;
    @Resource
    CitiesDao citiesDao;
    @Resource
    AreasDao areasDao;

    @RequestMapping("/index")
    public String gotoPcaPage(Map<String,Object> map){
        map.put("provinceList",provincesDao.query(null));
        return "pcaIndex";
    }

    @RequestMapping("/getCities")
    @ResponseBody
    public List<Cities> getCities(@RequestParam(value = "provCode") String code){
        if(!StringUtils.isEmpty(code)){
            Map<String,Object> params = new HashMap<>();
            params.put("provinceCode",code);
            List<Cities> citiesList = citiesDao.query(params);
            return citiesList;
        }
        return null;
    }

    @RequestMapping("/getAreas")
    @ResponseBody
    public List<Areas> getAreas(@RequestParam(value = "cityCode") String code){
        if(!StringUtils.isEmpty(code)){
            Map<String,Object> params = new HashMap<>();
            params.put("cityCode",code);
            List<Areas> areasList = areasDao.query(params);
            return areasList;
        }
        return null;
    }

    @RequestMapping("/savePCA")
    public void savePCA(PCAInfo info, HttpServletResponse response) throws IOException{
        response.getWriter().println(info.toString());
    }
}
