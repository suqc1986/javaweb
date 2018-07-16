package cn.suqc.dao;

import cn.suqc.entity.Provinces;
@MyBatisDao
public interface ProvincesDao extends MyBatisBaseDao<Provinces> {
    public Provinces queryProvinceByCode(String provinceCode);
}
