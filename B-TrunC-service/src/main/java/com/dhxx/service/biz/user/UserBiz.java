package com.dhxx.service.biz.user;

import com.dhxx.common.entity.dto.UserDTO;
import com.dhxx.common.entity.ms.MsInfo;
import com.dhxx.common.entity.user.User;
import com.dhxx.common.utils.Sha1;
import com.dhxx.service.mapper.ms.MsMapper;
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
 *
 * @author hanrs
 * Date: 2017年7月16日
 * @version 1.01
 */
@Service
@Transactional
public class UserBiz {

    private static Logger logger = LoggerFactory.getLogger(UserBiz.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MsMapper msMapper;

    //登陆
    public User login(User user) {
        try {
            User u = userMapper.infoByAccout(user.getAccount());
            if (u != null) {
                String password = Sha1.encryptSHA(u.getSalt() + user.getPassword());
                if (u.getPassword().equals(password)) {
                    return u;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //新增用户
    public void save(User user) {
        try {
            //添加盐值
            String salt = Sha1.createSalt();
            user.setSalt(salt);

            //密码加密
            String password = Sha1.encryptSHA(salt + user.getPassword());
            user.setPassword(password);

            user.setRoleId(Long.parseLong("1"));// 角色
            user.setStatus(0);// 状态 0: 启用 1:禁用
            user.setRegisterDate(new Date());
            try {
                userMapper.save(user);
                if (user.getId() > 0) {
                    MsInfo msInfo = new MsInfo();
                    msInfo.setUdn(user.getUdn());
                    if (user.getImsi() != null) {
                        msInfo.setImsi(user.getImsi());
                    }
                    msMapper.save(msInfo);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //修改用户信息
    public void update(User user) {
        try {
            if (user.getPassword() != null) {
                //添加盐值
                String salt = Sha1.createSalt();
                user.setSalt(salt);
                //密码加密
                String password = Sha1.encryptSHA(salt + user.getPassword());
                user.setPassword(password);
                user.setSalt(salt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        userMapper.update(user);
    }

    //删除用户
    public void delete(User user) {
        userMapper.delete(user);
    }

    //查看个人信息
    public UserDTO personalInfo(UserDTO userDTO) {
        return userMapper.personalInfo(userDTO);
    }

    public List<User> findUserByPage(UserDTO userDTO) { return userMapper.findUserByPage(userDTO); }

    //根据通话类型查询通话记录总页数
    public Integer findUserByCount(UserDTO userDTO) {
        double count =  userMapper.findUserByCount(userDTO);
        int totalPages = (int) Math.ceil(count/ userDTO.getPageSize());
        return totalPages;
    }
}
