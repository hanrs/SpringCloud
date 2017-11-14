package com.dhxx.common.entity.province;

/**
 * @author  liangz
 * Date 2017-10-26
 * @version 1.01
 * TB_PROVINCE
 */
public class Province {
    private Long id;
    private Long provinceId;
    private String province;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getProvinceId() { return provinceId; }

    public void setProvinceId(Long provinceId) { this.provinceId = provinceId; }

    public String getProvince() { return province; }

    public void setProvince(String province) { this.province = province; }
}
