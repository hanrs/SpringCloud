package com.dhxx.common.entity.vo;

public class UserVo {
    private String udn; //登陆的udn
    private String callUdn; //被查看个人信息的udn
    private String grpId; //群组号码
    private String UserName;    //被查看个人信息的用户名
    private String role; //角色
    private Integer onlineStatus;   //被查看个人信息的状态
    private Integer subType;    //与被查看个人信用户的订阅关系

    private Integer pageNow;
    private Integer pageSize;

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public String getCallUdn() { return callUdn; }

    public void setCallUdn(String callUdn) { this.callUdn = callUdn; }

    public String getGrpId() { return grpId; }

    public void setGrpId(String grpId) { this.grpId = grpId; }

    public String getUserName() { return UserName; }

    public void setUserName(String userName) { UserName = userName; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public Integer getOnlineStatus() { return onlineStatus; }

    public void setOnlineStatus(Integer onlineStatus) { this.onlineStatus = onlineStatus; }

    public Integer getSubType() { return subType; }

    public void setSubType(Integer subType) { this.subType = subType; }

    public Integer getPageNow() { return pageNow; }

    public void setPageNow(Integer pageNow) { this.pageNow = pageNow; }

    public Integer getPageSize() { return pageSize;
    }

    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
