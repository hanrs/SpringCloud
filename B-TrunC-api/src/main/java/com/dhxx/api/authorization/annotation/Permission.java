package com.dhxx.api.authorization.annotation;

import java.lang.annotation.*;

/**
 * <p> 类说明 </p>
 * @author liangz
 * @date 2017/10/31
 * @version 1.01
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
@Inherited
public @interface Permission {
    String description()  default "权限认证开始...";
}
