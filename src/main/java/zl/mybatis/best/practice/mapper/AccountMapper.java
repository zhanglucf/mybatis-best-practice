package zl.mybatis.best.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import zl.mybatis.best.practice.entity.Account;

@Mapper
public interface AccountMapper {
    int insert(Account a);
}
