package zl.mybatis.best.practice.support;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class RespondResultInterceptor implements HandlerInterceptor {
    private static final String RESPOND_RESULT_ANN = "RESPOND_RESULT_ANN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPOND_RESULT_ANN, clazz.getAnnotation(ResponseResult.class));
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPOND_RESULT_ANN, method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
