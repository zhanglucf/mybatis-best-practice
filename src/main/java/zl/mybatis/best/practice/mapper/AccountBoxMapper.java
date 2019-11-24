package zl.mybatis.best.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import zl.mybatis.best.practice.entity.AccountBox;

@Mapper
public interface AccountBoxMapper {
    int insert(AccountBox accountBox);

    AccountBox findByCloudBoxId(long cloudBoxId);
}
