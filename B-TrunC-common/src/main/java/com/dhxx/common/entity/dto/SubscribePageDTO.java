package com.dhxx.common.entity.dto;

/**
 * @author liangz
 * Date 2017-10-21
 * @version 1.01
 */
public class SubscribePageDTO {
    private Integer pageNow;
    private Integer pageSize;

    public Integer getPageNow() { return pageNow; }

    public void setPageNow(Integer pageNow) { this.pageNow = pageNow; }

    public Integer getPageSize() { return pageSize; }

    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
