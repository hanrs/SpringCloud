package com.dhxx.api.rest.area;

import com.dhxx.api.rpc.area.AreaFeignClient;
import com.dhxx.common.entity.area.Area;
import com.dhxx.common.entity.city.City;
import com.dhxx.common.entity.province.Province;
import com.dhxx.common.utils.Resp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private AreaFeignClient areaFeignClient;

    @PostMapping("list")
    public Object list() throws Exception {
        List<Province> list = new ArrayList<Province>();
        try {
            list =areaFeignClient.list();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("cityList")
    public Object cityList(@RequestBody City city) throws  Exception {
        logger.debug("/area/cityList>>>>city="+ city);
        List<City> list = new ArrayList<City>();
        try {
            list = areaFeignClient.cityList(city);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("areaList")
    public Object areaList(@RequestBody Area area) throws  Exception {
        logger.debug("/area/areaList>>>>area="+ area);
        List<Area> list = new ArrayList<Area>();
        try {
            list = areaFeignClient.areaList(area);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

}
