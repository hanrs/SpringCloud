package com.dhxx.api.authorization.manager.impl;

import com.dhxx.api.authorization.manager.PermissionManager;
import com.dhxx.common.entity.roleper.RolePermission;
import com.dhxx.common.entity.user.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 通过Redis存储
 * @author liangz
 * @date 2017/10/31
 */
@Component
public class RedisPermissionManager implements PermissionManager{
    private static Logger logger = LoggerFactory.getLogger(RedisPermissionManager.class);

    private static final String ACCOUNT = "account:";
    private static final String USER = "user:";
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        // 泛型设置成Long后必须更改对应的序列化方案
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    @SuppressWarnings("unused")
    public Long findAccountByUser(UserInfo userInfo) {
        Long time = redisTemplate.boundValueOps(ACCOUNT + userInfo.getAccount()).getExpire();
        return time;
    }

    @Override
    public void createAccount(List<RolePermission> list, String account) throws Exception {
        redisTemplate.boundValueOps(ACCOUNT + account).set(list, 2, TimeUnit.HOURS);
    }

    @Override
    public List<RolePermission> getAccount(String account) {
        if (account == null || account.length() == 0) {
            return null;
        }

        List<RolePermission> list = (List<RolePermission>) redisTemplate.boundValueOps(ACCOUNT + account).get();
        return list;
    }

    @Override
    public boolean checkAccount(List<RolePermission> list, String account, String url) {
        logger.debug("RedisPermissionManager>>>>>>url=" + url);

        boolean flag = false;
        if(list!=null) {
            for (int i = 0; i < list.size(); i++) {
                logger.debug("RedisPermissionManager>>>>>>menuUrl" + i + "=" + list.get(i).getMenuUrl());
                if (list.get(i).getMenuUrl().equals(url)) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            return flag;
        }
        // 如果验证成功，说明此用户进行了一次有效操作，延长account的过期时间
        redisTemplate.boundValueOps(ACCOUNT + account).expire(2, TimeUnit.HOURS);
        return flag;
    }

    @Override
    public void deleteAccount(String account) {
        redisTemplate.delete(ACCOUNT + account);
    }

}
