package com.dhxx.service.mapper.user;

import com.dhxx.common.entity.user.User;

import java.util.List;


public interface UserMapper {
    
    User info(User user);
    
    void save(User user);
    
    void update(User user);
    
    void delete(User u);
    
    List<User> list(User user);
    
    List<User> listByName(String userName);

}
