package com.dhxx.api.authorization.aspect;

import com.dhxx.api.authorization.manager.PermissionManager;
import com.dhxx.common.entity.roleper.RolePermission;
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
import java.util.List;


/**
 * <p> 类说明 </p>
 * @author liangz
 * @date 2017/10/31
 * @version 1.01
 *
 */
@Aspect
@Component
public class PermissionAspect {

    private static Logger logger = LoggerFactory.getLogger(PermissionAspect.class);

    @Autowired
    PermissionManager manager;

    // Controller层切点
    @Pointcut("@annotation(com.dhxx.api.authorization.annotation.Permission)")
    public void controllerAspect() {
       logger.debug("Permission切入点");
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint
     *            切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) { logger.debug("=====SysLogAspect前置通知开始====="); }

    @Around("controllerAspect()")
    @RequestMapping(produces = "application/json; charset=UTF-8")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.debug("=====SysLogAspect 环绕通知开始=====");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String account = request.getHeader("account");
        String url = request.getRequestURI();
        List<RolePermission> list = null;

        list = manager.getAccount(account);// 从redis获取

        if (manager.checkAccount(list, account, url)) {
                logger.info("the user Account is " + account);
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
