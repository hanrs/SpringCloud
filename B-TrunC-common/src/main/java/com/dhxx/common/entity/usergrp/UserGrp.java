package com.dhxx.common.entity.usergrp;

/**
 * @author liangz
 * Date 2017-10-20
 * @version 1.01
 * 用户群组关系订阅表：TB_USER_GRP_SUB
 */
public class UserGrp {
    private Long id;
    private String account; //用户账号
    private String grpId; //群组ID
    private Integer isSubCall; //呼叫状态获取订阅（0不订阅1已订阅） null也为不订阅

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id;}

    public String getAccount() { return account; }

    public void setAccount(String account) { this.account = account; }

    public String getGrpId() { return grpId; }

    public void setGrpId(String grpId) {this.grpId = grpId; }

    public Integer getIsSubCall() { return isSubCall; }

    public void setIsSubCall(Integer isSubCall) { this.isSubCall = isSubCall; }
}
