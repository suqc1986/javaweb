package ehcache;

import cn.suqc.dao.UserDao;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;

import static org.springframework.util.ResourceUtils.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-core.xml")
public class TestEhcache {
    @Autowired
    CacheManager cacheManager;
    @Autowired
    UserDao userDao;
    @Test
    public void test01() throws Exception{
        Resource resource = new ClassPathResource("config/ehcache.xml");
        System.out.println(resource.getURL());
        CacheManager cacheManager = CacheManager.create(resource.getInputStream());
        Cache cache = cacheManager.getCache("User");
        Element element = new Element("suqc","苏qc");
        cache.put(element);
        Element elem = cache.get("suqc");
        System.out.println(elem);
        System.out.println(elem.getObjectKey());
        System.out.println(elem.getObjectValue());
        cache.remove("suqc");
        cache.flush();
        cacheManager.shutdown();
    }

}

