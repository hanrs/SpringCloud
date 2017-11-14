package com.dhxx.common.entity.log;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年09月25日
 * @version 1.01
 * 操作日志记录表 (TB_LOG)
 */
public class Log {
    private Long id; //主键
    private Integer userId; //操作用户ID
    private String loginIp; //登陆IP
    private Integer type; //操作类型(0登陆,1登出，2增加业务，3删除业务，4修改业务，5查询业务)
    private String content; //操作内容
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date operationTime; //操作时间
    private String other; //其他

    private String userName; //操作用户名

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getLoginIp() { return loginIp; }

    public void setLoginIp(String loginIp) { this.loginIp = loginIp; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public Date getOperationTime() { return operationTime; }

    public void setOperationTime(Date operationTime) { this.operationTime = operationTime; }

    public String getOther() { return other; }

    public void setOther(String other) { this.other = other; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
}
