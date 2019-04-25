package org.kt.temp.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.kt.temp.annotation.IgnoreAuth;
import org.kt.temp.enums.HttpStatusEnum;
import org.kt.temp.pojo.User;
import org.kt.temp.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Token拦截器
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle=======================");
        // ***************** 不是映射方法直接通过 *****************
        if(!(handler instanceof HandlerMethod)) return true;

        // ***************** @IgnoreAuth注解，表示不需要登录验证，直接通过 *****************
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(method.getAnnotation(IgnoreAuth.class) != null) return true;

        // ***************** 认证携带的token *****************
        // 获取请求头传过来的Token
        String access_token = request.getHeader(Constans.AUTHORIZATION);
        // 检查token是否存在，如果存在验证该token的过期时间
        User result = tokenHelper.checkToken(access_token);
        if(result != null){
            // 把用户数据存放在Request请求作用域中
            request.setAttribute("user",result);
            return true;
        }

        // ***************** 验证未通过 *****************
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(R.error(HttpStatusEnum.UNAUTHORIZED.getCode(),HttpStatusEnum.UNAUTHORIZED.getMsg())));
        return false;
    }
}
