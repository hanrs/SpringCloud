package com.dhxx.common.entity.sms;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 短信记录表 (TB_SMS_LOG)
 */
public class SmsLog {
    private Long id; //主键
    private String udn; //接信息用户号码
    private String sendUdn; //发信息的用户号码
    private String content; //消息内容
    private Integer status; //阅读状态（0未阅读1已阅读）
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date recTime; //接收时间

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public String getSendUdn() { return sendUdn; }

    public void setSendUdn(String sendUdn) { this.sendUdn = sendUdn; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public Integer getStatus() { return status; }

    public void setStatus(Integer status) { this.status = status; }

    public Date getRecTime() { return recTime; }

    public void setRecTime(Date recTime) { this.recTime = recTime; }
}
