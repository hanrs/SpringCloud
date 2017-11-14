package com.dhxx.service.biz.area;

import com.dhxx.common.entity.area.Area;
import com.dhxx.common.entity.city.City;
import com.dhxx.common.entity.province.Province;
import com.dhxx.service.mapper.area.AreaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-26
 * @version 1.01
 */
@Service
@Transactional
public class AreaBiz {
    private static Logger logger = LoggerFactory.getLogger(AreaBiz.class);

    @Autowired
    private AreaMapper areaMapper;

    public List<Province> list() { return areaMapper.list(); }

    public List<City> cityList(City city) { return areaMapper.cityList(city); }

    public List<Area> areaList(Area area) { return areaMapper.areaList(area); }
}
