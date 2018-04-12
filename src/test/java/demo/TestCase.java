package demo;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

public class TestCase {
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
