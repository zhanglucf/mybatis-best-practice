package zl.mybatis.best.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import zl.mybatis.best.practice.entity.CloudBox;
import zl.mybatis.best.practice.util.MyMapper;

@Mapper
public interface CloudBoxMapper extends MyMapper {

    int insert(CloudBox cb);

    CloudBox find(long cloudBoxId);
}
