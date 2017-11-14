package com.dhxx.common.entity.city;

/**
 * @author  liangz
 * Date 2017-10-26
 * @version 1.01
 * TB_CITY
 */
public class City {
    private Long id;
    private Long cityId;
    private String city;
    private Long fatherId;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getCityId() { return cityId; }

    public void setCityId(Long cityId) { this.cityId = cityId; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public Long getFatherId() { return fatherId; }

    public void setFatherId(Long fatherId) { this.fatherId = fatherId; }
}
