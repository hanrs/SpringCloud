package com.dhxx.common.entity.grpms;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 群组终端关系表 (TB_GROUP_MS)
 */
public class GroupMs {
    private Long id; //主键
    private String grpId; //群组ID
    private String udn; //用户号码
    private Integer isSubCall; //呼叫状态获取订阅（0已订阅1不订阅）

    private String grpName; //群组名
    private String userName; //用户名

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getGrpId() { return grpId; }

    public void setGrpId(String grpId) { this.grpId = grpId; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public Integer getIsSubCall() { return isSubCall; }

    public void setIsSubCall(Integer isSubCall) { this.isSubCall = isSubCall; }

    public String getGrpName() { return grpName; }

    public void setGrpName(String grpName) { this.grpName = grpName; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
}
