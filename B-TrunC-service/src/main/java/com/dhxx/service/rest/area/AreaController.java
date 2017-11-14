package com.dhxx.service.rest.area;

import com.dhxx.common.entity.area.Area;
import com.dhxx.common.entity.city.City;
import com.dhxx.common.entity.province.Province;
import com.dhxx.service.biz.area.AreaBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-26
 * @version 1.01
 */
@RestController
@RequestMapping("area")
public class AreaController {
    private static Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaBiz areaBiz;

    @PostMapping("/list")
    public List<Province> list() {
        return areaBiz.list();
    }


    @PostMapping("cityList")
    public List<City> cityList(@RequestBody City city) {
        logger.debug("/area/cityList>>>>city="+ city);
        return areaBiz.cityList(city);
    }

    @PostMapping("areaList")
    public List<Area> areaList(@RequestBody Area area) {
        logger.debug("/area/areaList>>>>area="+ area);
        return areaBiz.areaList(area);
    }

}
