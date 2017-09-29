package com.dhxx.common.entity.group;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 群组信息表 (TB_GROUP_INFO)
 */
public class GroupInfo {
    private Long id; //主键
    private String prpId; //群组ID
    private String grpName; //群组名称
    private Integer type; //组呼类型（0语音组呼，1视频组呼）
    private Integer isTemp; //是否临时组（0不是1是）

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getPrpId() { return prpId; }

    public void setPrpId(String prpId) { this.prpId = prpId; }

    public String getGrpName() { return grpName; }

    public void setGrpName(String grpName) { this.grpName = grpName; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Integer getIsTemp() { return isTemp; }

    public void setIsTemp(Integer isTemp) { this.isTemp = isTemp; }
}
