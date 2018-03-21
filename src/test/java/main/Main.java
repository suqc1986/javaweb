package main;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import see.ItemEventService;

import java.util.EventObject;
public class Main {
    @Autowired
    Config config;
    @Test
    public void test1(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        ItemEventService service = (ItemEventService) ac.getBean("itemEventService");
        service.fireEvent(new EventObject(new String("你好spring.")));
        Config config = (Config)ac.getBean("config");
        System.out.println(config.getProperty("mail"));
    }
}
