package com.dhxx.common.entity.vo;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 * Ms分页查询 条件封装类
 */
public class MsPageVo {
    private Integer pageNow;
    private Integer pageSize;
    private String grpId;
    private String udn;

    public Integer getPageNow() { return pageNow; }

    public void setPageNow(Integer pageNow) { this.pageNow = pageNow; }

    public Integer getPageSize() { return pageSize; }

    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    public String getGrpId() { return grpId; }

    public void setGrpId(String grpId) { this.grpId = grpId; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }
}
