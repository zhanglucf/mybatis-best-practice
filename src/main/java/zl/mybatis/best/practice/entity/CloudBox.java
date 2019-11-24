package zl.mybatis.best.practice.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
public class CloudBox {

    private long cloudBoxId;

    private String sn;

    private String ip;

    private String depiction;

    private String cloudBoxName;

    private Date insertTime;

    private Date updateTime;
}
