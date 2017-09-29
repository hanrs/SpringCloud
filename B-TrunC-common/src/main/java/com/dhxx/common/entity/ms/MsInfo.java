package com.dhxx.common.entity.ms;


/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 终端信息表 (TB_MS_INFO)
 */
public class MsInfo {
    private Long id; //主键
    private String udn; //用户号码
    private Integer onineStatus; //在线状态（0空闲，1离线，2未注册，3通话中）
    private Integer status; //终端状态（0正常，1冻结）
    private Integer type; //设备类型
    private String imsi; //IMSI号码
    private Integer isTCN; //是否核心网激活（0否1是）
    private Integer isSubGroup; //所属组获取订阅（0不订阅1已订阅）
    private Integer isSubPegister; //注册状态获取订阅（0不订阅1已订阅）

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public Integer getOnineStatus() { return onineStatus; }

    public void setOnineStatus(Integer onineStatus) { this.onineStatus = onineStatus; }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public String getImsi() { return imsi; }

    public void setImsi(String imsi) { this.imsi = imsi; }

    public Integer getIsTCN() { return isTCN; }

    public void setIsTCN(Integer isTCN) { this.isTCN = isTCN; }

    public Integer getIsSubGroup() { return isSubGroup; }

    public void setIsSubGroup(Integer isSubGroup) { this.isSubGroup = isSubGroup; }

    public Integer getIsSubPegister() { return isSubPegister; }

    public void setIsSubPegister(Integer isSubPegister) { this.isSubPegister = isSubPegister; }
}
