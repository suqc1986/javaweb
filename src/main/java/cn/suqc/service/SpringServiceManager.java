package cn.suqc.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SpringServiceManager implements ApplicationContextAware{
    private static ApplicationContext applicationContext;
    private static WebApplicationContext wac = null;
    private static ReentrantLock lock = new ReentrantLock();
    private SpringServiceManager(){}
    private static WebApplicationContext getWebContext(){
        lock.lock();
        try {
            if(wac == null){
                wac = ContextLoader.getCurrentWebApplicationContext();
            }
        }finally {
            lock.unlock();
        }
        return wac;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringServiceManager.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static <T> List<T> getServicesByType(Class<T> type) {
        ArrayList<T> l = new ArrayList<T>();
        Map<String, T> beans;
        try
        {
            beans = getWebContext() == null ? getApplicationContext().getBeansOfType(type, true, true) :
                    getWebContext().getBeansOfType(type, true, true);
            l.addAll( (java.util.Collection<? extends T>) beans.values() );
        }
        catch (BeansException e) {
            throw new RuntimeException("Failed to get beans of type ("+ type +"): " + e.getMessage(), e);
        }

        return l;
    }

    public static <T> T getServiceByName(String beanName, Class<T> type) {
        return getWebContext() == null ? getApplicationContext().getBean(beanName, type) : getWebContext().getBean(beanName, type);
    }
}
