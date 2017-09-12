package com.dhxx.api.authorization;

import com.dhxx.api.authorization.manager.TokenManager;
import com.dhxx.common.entity.user.UserInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <p> 类说明 </p>
 * @author hanrs
 * @date 2017/08/11
 * @version 1.01
 *
 */
@Aspect
@Component
public class AuthorizationAspect {

    private static Logger logger = LoggerFactory.getLogger(AuthorizationAspect.class);

    @Autowired
    TokenManager manager;

    // Controller层切点
    @Pointcut("@annotation(com.dhxx.api.authorization.annotation.Authorization)")
    public void controllerAspect() {
       logger.debug("我是一个切入点");
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint
     *            切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        logger.debug("=====SysLogAspect前置通知开始=====");
    }

    @Around("controllerAspect()")
    @RequestMapping(produces = "application/json; charset=UTF-8")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.debug("=====SysLogAspect 环绕通知开始=====");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        UserInfo userInfo = null;

        userInfo = manager.getToken(token);// 从redis获取
        if (manager.checkToken(userInfo)) {
            logger.info("the user Account is " + userInfo.getUserAccount() + " using token is " + token);
            Object obj= joinPoint.proceed();
            logger.debug("=====SysLogAspect 环绕通知结束=====");
            return  obj;
        }else{
            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes()).getResponse();
            response.setStatus(response.SC_UNAUTHORIZED);
            return null;
        }

    }

    /**
     * 后通知（After advice） ：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
     * @param joinPoint
     */
    @AfterReturning(pointcut = "controllerAspect()")
    public void doAfter(JoinPoint joinPoint)
    {
        logger.debug("=====SysLogAspect后置通知开始=====");
    }

    @AfterReturning(pointcut="controllerAspect()", returning="object")
    public void after(JoinPoint joinPoint, Object object) {
        logger.debug("=====SysLogAspect异常通知开始=====");
        //ResponseEntity returnObj = (ResponseEntity) object;
    }

}
