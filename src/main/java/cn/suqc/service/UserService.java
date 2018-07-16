package cn.suqc.service;

import cn.suqc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public List<Map<Integer,Integer>> getAge2Cnt(){
        return userDao.queryAgeGroup();
    }
}
