package zl.mybatis.best.practice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AccountBox {

    private long accountBoxId;

    private long accountId;

    private long cloudBoxId;

    private Date insertTime;

    private Date updateTime;
}
