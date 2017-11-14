package com.dhxx.common.entity.dto;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 * Sms分页查询 条件封装类
 */
public class SmsPageDTO {
    private Integer pageNow; //当前页
    private Integer pageSize; //每页多少行
    private Integer type; //消息类型（0接收信息夹，1发送信息）
    private Integer isWeek; //是否一周内查询(0否，1是)
    private String startTime; //自定义时间查询 开始时间
    private String endTime; //自定义时间查询 结束时间
    private String queryContent; //要查询的内容 用户名或UDN
    private String udn; //登陆的用户号码

    public Integer getPageNow() { return pageNow; }

    public void setPageNow(Integer pageNow) { this.pageNow = pageNow; }

    public Integer getPageSize() { return pageSize; }

    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public Integer getIsWeek() { return isWeek; }

    public void setIsWeek(Integer isWeek) { this.isWeek = isWeek; }

    public String getStartTime() { return startTime; }

    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }

    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getQueryContent() { return queryContent; }

    public void setQueryContent(String queryContent) { this.queryContent = queryContent; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }
}
