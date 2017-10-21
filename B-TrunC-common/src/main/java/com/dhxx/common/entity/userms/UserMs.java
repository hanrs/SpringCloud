package com.dhxx.common.entity.userms;

/**
 * @author liangz
 * Date 2017-10-20
 * @version 1.01
 * 用户终端关系订阅表：TB_USER_MS_SUB
 */
public class UserMs {
    private Long id;
    private String account; //用户账号
    private String udn; //终端号码
    private Integer isSubGroup; //所属组获取订阅（0不订阅1已订阅）
    private Integer isSubRegister; //注册状态获取订阅（0不订阅1已订阅）
    private Integer isSubCall; //呼叫状态获取订阅（0不订阅1已订阅）

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getAccount() { return account; }

    public void setAccount(String account) { this.account = account; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public Integer getIsSubGroup() { return isSubGroup; }

    public void setIsSubGroup(Integer isSubGroup) { this.isSubGroup = isSubGroup; }

    public Integer getIsSubRegister() { return isSubRegister; }

    public void setIsSubRegister(Integer isSubRegister) { this.isSubRegister = isSubRegister; }

    public Integer getIsSubCall() { return isSubCall; }

    public void setIsSubCall(Integer isSubCall) { this.isSubCall = isSubCall; }
}
