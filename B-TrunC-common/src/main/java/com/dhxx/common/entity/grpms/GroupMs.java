package com.dhxx.common.entity.grpms;

import java.util.List;

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

    private String grpName; //群组名
    private String userName; //用户名
    private Integer onlineStatus; //在线状态（0空闲，1离线，2未注册，3通话中）
    private String pgrpId; //父级群组id

    private List<GroupMs> childMenus; //子菜单

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getGrpId() { return grpId; }

    public void setGrpId(String grpId) { this.grpId = grpId; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public String getGrpName() { return grpName; }

    public void setGrpName(String grpName) { this.grpName = grpName; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public Integer getOnlineStatus() { return onlineStatus; }

    public void setOnlineStatus(Integer onlineStatus) { this.onlineStatus = onlineStatus; }

    public String getPgrpId() { return pgrpId; }

    public void setPgrpId(String pgrpId) { this.pgrpId = pgrpId; }

    public List<GroupMs> getChildMenus() { return childMenus; }

    public void setChildMenus(List<GroupMs> childMenus) { this.childMenus = childMenus; }
}
