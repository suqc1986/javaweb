package cn.suqc.dao;

import cn.suqc.entity.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;
@MyBatisDao
public interface UserDao extends MyBatisBaseDao<User> {
    public List<Map<Integer,Object>> queryAgeGroup();
}
