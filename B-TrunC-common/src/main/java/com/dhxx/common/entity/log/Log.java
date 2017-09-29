package com.dhxx.common.entity.log;

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
    private Integer userId; //操作用户
    private String content; //操作内容
    private Integer type; // 日志类型(0调式级别1信息级别2警告级别3错误级别)
    private Date operationTime; //操作时间
    private String other; //其他

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Date getOperationTime() { return operationTime; }

    public void setOperationTime(Date operationTime) { this.operationTime = operationTime; }

    public String getOther() { return other; }

    public void setOther(String other) { this.other = other; }
}
