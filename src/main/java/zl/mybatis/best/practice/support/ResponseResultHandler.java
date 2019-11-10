package zl.mybatis.best.practice.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    private static final String RESPOND_RESULT_ANN = "RESPOND_RESULT_ANN";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPOND_RESULT_ANN);
        return responseResultAnn == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof Map && ((Map) body).get("error") != null) {
            return Result.failure(ResultCode.FAILURE, body);
        }
        return Result.success(body);
    }

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        log.error("全局异常捕捉处理 系统异常", ex);
        Map map = new LinkedHashMap();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        map.put("error", ex.getMessage());
        return map;
    }

    /**
     * 自定义异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public Map customExceptionHandler(Exception ex) {
        log.error(((CustomException) ex).getMsg(), ex);
        Map map = new LinkedHashMap();
        map.put("code", ((CustomException) ex).getCode());
        map.put("msg", ((CustomException) ex).getMsg());
        map.put("error", ((CustomException) ex).getDesc());
        return map;
    }

}
