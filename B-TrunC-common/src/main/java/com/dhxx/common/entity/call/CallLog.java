package com.dhxx.common.entity.call;

import java.util.Date;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 通话记录表 (TB_CALL_LOG)
 */
public class CallLog {
    private Long id; //主键
    private String udn; //用户号码
    private String callerUdn; //来电用户号码
    private Integer type; //呼叫状态(0呼入1呼出2未接来电3通话中)
    private Integer isEmgCall; //是否紧急呼叫（0否1是）
    private Date startTime; //开始时间
    private Date endTime; //结束时间

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public String getCallerUdn() { return callerUdn; }

    public void setCallerUdn(String callerUdn) { this.callerUdn = callerUdn; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Integer getIsEmgCall() { return isEmgCall; }

    public void setIsEmgCall(Integer isEmgCall) { this.isEmgCall = isEmgCall; }

    public Date getStartTime() { return startTime; }

    public void setStartTime(Date startTime) { this.startTime = startTime;}

    public Date getEndTime() { return endTime; }

    public void setEndTime(Date endTime) { this.endTime = endTime; }
}
