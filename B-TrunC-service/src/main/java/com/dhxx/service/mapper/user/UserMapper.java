package com.dhxx.service.mapper.user;

import com.dhxx.common.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liangz
 * Date: 2017-9-28
 * @version 1.01
 */
public interface UserMapper {

    void save(User user); //增

    void delete(User u);  //删

    void update(User user); //改

    User infoByAccout(@Param("account") String account); //根据账号查找用户信息

    List<User> list(User user);
    
}
