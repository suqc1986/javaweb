package cn.suqc.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@MyBatisDao
@Repository
public interface AllDao extends MyBatisBaseDao<Object>{
    public List<Map<String,String>> getAll(Map<String,Object> params, PageBounds pb);
}
