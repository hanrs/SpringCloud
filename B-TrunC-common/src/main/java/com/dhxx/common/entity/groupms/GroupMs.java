package com.dhxx.common.entity.groupms;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 群组终端关系表 (TB_GROUP_MS)
 */
public class GroupMs {
    private Integer id; //主键
    private String grpId; //群组ID
    private String udn; //用户号码
    private Integer isSubCall; //呼叫状态获取订阅（0已订阅1不订阅）
    private String remark; //备注

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getGrpId() { return grpId; }

    public void setGrpId(String grpId) { this.grpId = grpId; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public Integer getIsSubCall() { return isSubCall; }

    public void setIsSubCall(Integer isSubCall) { this.isSubCall = isSubCall; }

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark; }
}
