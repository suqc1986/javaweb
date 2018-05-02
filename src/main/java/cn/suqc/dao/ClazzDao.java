package cn.suqc.dao;

import cn.suqc.entity.Clazz;
import org.springframework.stereotype.Repository;

import java.util.List;

@MyBatisDao
@Repository
public interface ClazzDao extends MyBatisBaseDao<Clazz>{

    Clazz queryClassById1(int id);

    Clazz queryClassById2(int id);
}

