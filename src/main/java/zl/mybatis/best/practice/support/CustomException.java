package zl.mybatis.best.practice.support;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException {
    private long code;
    private String msg;
    private String desc;
}
