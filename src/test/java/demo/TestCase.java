package demo;

import cn.suqc.dao.AllDao;
import com.alibaba.fastjson.JSONObject;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-core.xml"})
public class TestCase {
    @Autowired
    AllDao allDao;
    @Test
    public void test5(){
        Map<String,Map<String,String>> data = allDao.getAllMap(null,new PageBounds());
//        JSONObject object = new JSONObject();
//        object.putAll(data);
//        System.out.println(object.toString());
        System.out.println(data);
        System.out.println(JSONObject.toJSONString(data,true));
//        JsonConfig jsonConfig = new JsonConfig();
//        // 排除,避免循环引用 There is a cycle in the hierarchy!
//        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
//        jsonConfig.setIgnoreDefaultExcludes(true);
//        jsonConfig.setAllowNonStringKeys(true);
//        System.out.println(JSONObject.fromObject(data,jsonConfig));
    }
    @Test
    public void test4(){
        boolean fund = false;
        for(int i=0;i<10;i++){
            if(i%2==0) {
                for(int j=0;j<5;j++) {
                    for(int k=0;k<3;k++) {
                        if(k==4) {
                            System.out.println("i="+i+",j="+j+",k="+k);
                            fund = true;
                            break;
                        }
                    }
                    if(fund) break;
                }
            }
            fund = false;
        }
    }
    @Test
    public void test3(){
        Long n = new Long(10L);
        System.out.println(Integer.parseInt(n.toString()));
    }
    @Test
    //TODO 截取集合   返回新集合
    public void test2(){
        List<String> list = Lists.newArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list.subList(1,3));//[B, C]
        System.out.println(list);//[A, B, C, D]
    }
    @Test
    //TODO 自义定类型排序   按时间倒序排序
    public void test1(){
        List<Date> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add((int)(Math.random()*list.size()),new Date());
        }
        System.out.println("排序前:");
        prinf(list);
        Collections.sort(list, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o1.getTime()-o2.getTime()>0?-1:1;
            }
        });
        System.out.println("排序后:");
        prinf(list);
    }
    public void prinf(List<Date> list){
        for(Date d:list){
            System.out.println(d.toLocaleString());
        }
    }
}
