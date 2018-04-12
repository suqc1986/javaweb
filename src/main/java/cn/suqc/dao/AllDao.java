package cn.suqc.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@MyBatisDao
@Repository
public interface AllDao extends MyBatisBaseDao<Object>{
    public List<Map<String,String>> getAllList(Map<String,Object> params, PageBounds pb);

    public List<Map<String,String>> getAllList2(Map<String,Object> params, PageBounds pb);
    @MapKey("id")
    public Map<String,Map<String,String>> getAllMap(Map<String,Object> params, PageBounds pb);
}
