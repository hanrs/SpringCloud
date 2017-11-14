package com.dhxx.common.entity.area;

/**
 * @author  liangz
 * Date 2017-10-26
 * @version 1.01
 * TB_AREA
 */
public class Area {
    private Long id;
    private Long areaId;
    private String area;
    private Long fatherId;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getAreaId() { return areaId; }

    public void setAreaId(Long areaId) { this.areaId = areaId; }

    public String getArea() { return area; }

    public void setArea(String area) { this.area = area; }

    public Long getFatherId() { return fatherId; }

    public void setFatherId(Long fatherId) { this.fatherId = fatherId; }
}
