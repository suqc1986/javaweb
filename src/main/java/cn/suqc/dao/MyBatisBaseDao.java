package cn.suqc.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
import java.util.Map;

public interface MyBatisBaseDao<T> {
    public T findUnique(Map<String, Object> params);

    public T getById(Integer id);

    public List<T> query(Map<String, Object> params);

    public List<T> query(Map<String, Object> params, PageBounds pageBounds);

    public Integer create(T t);

    public Integer update(T t);

    public Integer deleteById(Integer id);

    public Integer delete(List<String> ids);

    public Integer delete(Map<String, Object> params);
}
