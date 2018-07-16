package cn.suqc.dao;

import cn.suqc.entity.Cities;
import cn.suqc.entity.Provinces;

@MyBatisDao
public interface CitiesDao extends MyBatisBaseDao<Cities> {
    public Cities queryCityByCode(String cityCode);
}
