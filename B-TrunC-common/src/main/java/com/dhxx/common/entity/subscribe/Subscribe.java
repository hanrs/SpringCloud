package com.dhxx.common.entity.subscribe;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 订阅表 (TB_SUBSCRIBE)
 */
public class Subscribe {
    private Long id; //主键
    private Integer userId; //用户id
    private String udn; //主叫号码
    private String callerUdn; //被叫号码
    private Integer callStatus; //呼叫状态
    private Integer callType; //呼叫类型
    private Integer prioAttribute;//优先级类别
    private Integer duplex; //单双工指示
    private Integer e2ee; //加密指示
    private Integer type; //订阅类型（0用户呼叫状态1组呼叫状态2系统通话状态）
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime; //建立时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime; //结束时间

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public String getCallerUdn() { return callerUdn; }

    public void setCallerUdn(String callerUdn) { this.callerUdn = callerUdn; }

    public Integer getCallStatus() { return callStatus; }

    public void setCallStatus(Integer callStatus) { this.callStatus = callStatus; }

    public Integer getCallType() { return callType; }

    public void setCallType(Integer callType) { this.callType = callType; }

    public Integer getPrioAttribute() { return prioAttribute; }

    public void setPrioAttribute(Integer prioAttribute) { this.prioAttribute = prioAttribute; }

    public Integer getDuplex() { return duplex; }

    public void setDuplex(Integer duplex) { this.duplex = duplex; }

    public Integer getE2ee() { return e2ee; }

    public void setE2ee(Integer e2ee) { this.e2ee = e2ee; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Date getStartTime() { return startTime; }

    public void setStartTime(Date startTime) { this.startTime = startTime; }

    public Date getEndTime() { return endTime; }

    public void setEndTime(Date endTime) { this.endTime = endTime; }
}
