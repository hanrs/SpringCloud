package com.dhxx.service.biz.user;

import com.dhxx.common.entity.user.User;
import com.dhxx.service.mapper.user.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p> 类说明 </p>
 * @author hanrs
 * Date: 2017年7月16日
 * @version 1.01
 *
 */
@Service
@Transactional
public class UserBiz {

    private static Logger logger = LoggerFactory.getLogger(UserBiz.class);

    @Autowired
    private UserMapper userMapper;

    public User info(User user){
        return userMapper.info(user);
    }
    
    public void save(User user){
        user.setRole("provider");// 角色
        user.setStatus(0);// 状态 0: 启用 1:禁用
        user.setRegisterDate(new Date());
        userMapper.save(user);
    }

    
    public void updatePasswd(User user){
    	userMapper.update(user);
    }
    
    public void update(User user){
        userMapper.update(user);
    }

    public List<User> listByName(String userName) {
        return userMapper.listByName(userName);
    }

    public void udapteStatus(User user) {
        userMapper.update(user);
    }

    public void reset(User user) {
        userMapper.update(user);
    }

    public void updateInfo(User user) {
        userMapper.update(user);
    }


}
