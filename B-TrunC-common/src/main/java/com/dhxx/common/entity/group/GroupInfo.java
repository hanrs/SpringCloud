package com.dhxx.common.entity.group;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 群组信息表 (TB_GROUP_INFO)
 */
public class GroupInfo {
    private Long id; //主键
    private String grpId; //群组ID
    private String grpName; //群组名称
    private Integer type; //组呼类型（0语音组呼，1视频组呼）
    private Integer isTemp; //是否临时组（0不是1是）
    private Integer meetType; //会议模式（0自由模式1麦序模式2主席模式）
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime; //创建时间
    private String remark; //备注
    private String pgrpId; //父级群组ID，0代表一级群组，最多二级群组

    private Integer count; //某个群组下的用户总数
    private Integer isSubCall; //呼叫状态获取订阅（0不订阅1已订阅）
    private Integer ugId; //用户组订阅关系表id

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getGrpId() { return grpId; }

    public void setGrpId(String grpId) { this.grpId = grpId; }

    public String getGrpName() { return grpName; }

    public void setGrpName(String grpName) { this.grpName = grpName; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Integer getIsTemp() { return isTemp; }

    public void setIsTemp(Integer isTemp) { this.isTemp = isTemp; }

    public Integer getMeetType() { return meetType; }

    public void setMeetType(Integer meetType) { this.meetType = meetType; }

    public Date getCreateTime() { return createTime; }

    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark; }

    public Integer getCount() { return count; }

    public void setCount(Integer count) { this.count = count; }

    public String getPgrpId() { return pgrpId; }

    public void setPgrpId(String pgrpId) { this.pgrpId = pgrpId; }

    public Integer getIsSubCall() { return isSubCall; }

    public void setIsSubCall(Integer isSubCall) { this.isSubCall = isSubCall; }

    public Integer getUgId() { return ugId; }

    public void setUgId(Integer ugId) { this.ugId = ugId;
    }
}
