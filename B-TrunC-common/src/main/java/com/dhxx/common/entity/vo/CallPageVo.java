package com.dhxx.common.entity.vo;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 * Call分页查询 条件封装类
 */
public class CallPageVo {
    private Integer pageNow; //当前页
    private Integer pageSize; //每页最大行数
    private Integer type; //呼叫状态(0呼入1呼出2未接来电3通话中)
    private String udn; //用户号码

    public Integer getPageNow() { return pageNow; }

    public void setPageNow(Integer pageNow) { this.pageNow = pageNow; }

    public Integer getPageSize() { return pageSize; }

    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    public Integer getType() { return type; }

    public void setType(Integer type) { this.type = type; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }
}
