package one2many;

import cn.suqc.dao.CitiesDao;
import cn.suqc.dao.ProvincesDao;
import cn.suqc.entity.Cities;
import cn.suqc.entity.Provinces;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:spring/spring-*.xml")
public class TestMany {
    @Resource
    ProvincesDao provincesDao;
    @Resource
    CitiesDao citiesDao;
    @Test
    public void TestProvince2(){
        List<Provinces> provinces = provincesDao.query(null);
        System.out.println(provinces);
    }
    @Test
    public void TestProvince(){
        Provinces province = provincesDao.queryProvinceByCode("230000");
        List<Cities> citiesList = province.getCitiesList();
        for(Cities city:citiesList){
            System.out.println(city.getCityName()+":"+city.getAreasList());
        }
//        Cities city = citiesDao.queryCityByCode("230600");
//        System.out.println(city.getCityName()+":"+city.getAreasList());
    }
}
