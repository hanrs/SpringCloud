package com.dhxx.common.entity.vo;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 * Grp分页查询 条件封装类
 */
public class GrpPageVo {
    private Integer pageNow;
    private Integer pageSize;
    private String udn;
    private Integer isTemp; //是否临时组（0不是1是）
    private String account; //账号

    public Integer getPageNow() { return pageNow; }

    public void setPageNow(Integer pageNow) { this.pageNow = pageNow; }

    public Integer getPageSize() { return pageSize; }

    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    public String getUdn() { return udn; }

    public void setUdn(String udn) { this.udn = udn; }

    public Integer getIsTemp() { return isTemp; }

    public void setIsTemp(Integer isTemp) { this.isTemp = isTemp; }

    public String getAccount() { return account; }

    public void setAccount(String account) { this.account = account; }
}
