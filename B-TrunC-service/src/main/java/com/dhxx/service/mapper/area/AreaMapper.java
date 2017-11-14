package com.dhxx.service.mapper.area;

import com.dhxx.common.entity.area.Area;
import com.dhxx.common.entity.city.City;
import com.dhxx.common.entity.province.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-26
 * @version 1.01
 */
public interface AreaMapper {
    List<Province> list();

    List<City> cityList(City city);

    List<Area> areaList(Area area);
}
