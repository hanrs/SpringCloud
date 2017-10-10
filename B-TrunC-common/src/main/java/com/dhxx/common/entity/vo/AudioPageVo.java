package com.dhxx.common.entity.vo;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 * Audio分页查询 条件封装类
 */
public class AudioPageVo {
    private Integer pageNow; //当前页
    private Integer pageSize; //每页行数
    private Integer type;   //记录类型（0录音文件夹，1照片文件夹2录像文件夹）
    private Integer isWeek; //是否一周内查询(0否，1是)
    private String startTime; //自定义时间查询 开始时间
    private String endTime; //自定义时间查询 结束时间
    private String userName; //用户名
    private String queryUdn; //要查找的用户号码
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

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getQueryUdn() { return queryUdn; }

    public void setQueryUdn(String queryUdn) { this.queryUdn = queryUdn; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }
}
