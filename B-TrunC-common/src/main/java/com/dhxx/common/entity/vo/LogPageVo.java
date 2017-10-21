package com.dhxx.common.entity.vo;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 * Log分页查询 条件封装类
 */
public class LogPageVo {
    private Integer pageNow; //当前页
    private Integer pageSize; //每页多少行
    private String startTime; //开始时间
    private String endTime; //结束时间
    private String userName; //用户名

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
