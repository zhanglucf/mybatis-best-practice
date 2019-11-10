package zl.mybatis.best.practice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {

    private int id;

    private String dbName;

    private String authorName;

    private String blogTitle;

    private String blogContent;

    private Date insertTime;

    private Date updateTime;
}
