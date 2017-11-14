package com.dhxx.api.rpc.area;

import com.dhxx.common.entity.area.Area;
import com.dhxx.common.entity.city.City;
import com.dhxx.common.entity.province.Province;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-26
 * @version 1.01
 */
@Primary
@FeignClient(name = "B-TrunC-service", fallback = AreaFeignClient.HystrixAreaFeignClientFallback.class)
public interface AreaFeignClient {

    @PostMapping("/B-TrunC-service/area/list")
    public List<Province> list();

    @PostMapping("/B-TrunC-service/area/cityList")
    public List<City> cityList(City city);

    @PostMapping("/B-TrunC-service/area/areaList")
    public List<Area> areaList(Area area);



    @Component
    static class HystrixAreaFeignClientFallback implements AreaFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixAreaFeignClientFallback.class);


        @Override
        public List<Province> list() {
            log.error("application=B-TrunC-service,url=/area/list 异常发生，进入fallback方法");
            return null;
        }

        @Override
        public List<City> cityList(City city) {
            log.error("application=B-TrunC-service,url=/area/cityList 异常发生，进入fallback方法 city:" + city);
            return null;
        }

        @Override
        public List<Area> areaList(Area area) {
            log.error("application=B-TrunC-service,url=/area/areaList 异常发生，进入fallback方法 area:" + area);
            return null;
        }

    }
}