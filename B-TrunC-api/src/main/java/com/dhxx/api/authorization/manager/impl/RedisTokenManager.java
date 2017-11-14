package com.dhxx.api.authorization.manager.impl;
/**
 * 通过Redis存储和验证token的实现类
 *
 * @see com.dhxx.api.authorization.manager.TokenManager
 * @author hanrs
 * @date 2017/08/11
 */
import com.dhxx.api.authorization.manager.TokenManager;
import com.dhxx.common.entity.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 通过Redis存储和验证token的实现类
 * 
 * @see com.dhxx.api.authorization.manager.TokenManager
 * @author hanrs
 * @date 2017/08/11
 */
@Component
public class RedisTokenManager implements TokenManager {

    private static final String ACCESS = "access:";
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
    public Long findTokenByUser(UserInfo userInfo) {
        String token = (String) redisTemplate.boundValueOps(USER + userInfo.getAccount()).get();
        Long time = redisTemplate.boundValueOps(ACCESS + userInfo.getToken()).getExpire();
        return time;
    }

    public void createToken(UserInfo userInfo) throws Exception {

        redisTemplate.boundValueOps(ACCESS + userInfo.getToken()).set(userInfo, 2, TimeUnit.HOURS);

    }

    public UserInfo getToken(String token) {
        if (token == null || token.length() == 0) {
            return null;
        }

        UserInfo userInfo = (UserInfo) redisTemplate.boundValueOps(ACCESS + token).get();
        return userInfo;
    }

    public boolean checkToken(UserInfo userInfo) {
        if (userInfo == null) {
            return false;
        }
        // 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redisTemplate.boundValueOps(ACCESS + userInfo.getToken()).expire(2, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(String token) {
        redisTemplate.delete(ACCESS + token);
    }

}
