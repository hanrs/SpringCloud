package com.dhxx.api.authorization.manager;

import com.dhxx.common.entity.user.UserInfo;

/**
 * 对Token进行操作的接口
 * @author hanrs
 * @date 2017/08/11.
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     * @param userInfo 指定用户的UserInfo
     * @return 生成的token
     */
    public void createToken(UserInfo userInfo) throws Exception;

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public boolean checkToken(UserInfo model);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public UserInfo getToken(String authentication);

    /**
     * 清除token
     * @param token 登录用户的token
     */
    public void deleteToken(String token);

}
