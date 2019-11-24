package zl.mybatis.best.practice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Account {

    private Long accountId;

    private String name;

    private String nickName;

    private String email;

    private String phone;

    private Date insertTime;

    private Date updateTime;
}
