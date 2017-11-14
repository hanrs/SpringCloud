package com.dhxx.common.entity.user;

import java.io.Serializable;

public class UserInfo implements Serializable {

    /** 属性说明 */
    private static final long serialVersionUID = 1L;

    private String userName;// 用户名称

    private String account;// 登录帐号
    
    private Long roleId;// 角色
    
    private String token;//身份令牌

    private String openId;// //普通用户的标识，对当前公众号唯一
    
    private String imToken;// 融云即时通讯身份令牌

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() { return account; }

    public void setAccount(String account) { this.account = account; }

    public Long getRoleId() { return roleId; }

    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getImToken() {
        return imToken;
    }

    public void setImToken(String imToken) {
        this.imToken = imToken;
    }
}
