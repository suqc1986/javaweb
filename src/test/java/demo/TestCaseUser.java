package demo;

import cn.suqc.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-core.xml")
public class TestCaseUser {
    @Autowired
    UserDao userDao;
    @Test
    public void test1(){
        List<Map<Integer,Object>> list = userDao.queryAgeGroup();
        System.out.println(list.get(0).get("age").getClass());
    }
}
