package com.dhxx.service.rest.subscribe;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.dto.SubscribePageDTO;
import com.dhxx.common.entity.subscribe.Subscribe;
import com.dhxx.service.biz.subscribe.SubscribeBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 */
@RestController
@RequestMapping("sub")
public class SubscribeController {
    private static Logger logger = LoggerFactory.getLogger(SubscribeController.class);

    @Autowired
    private SubscribeBiz subscribeBiz;

    @PostMapping("/save")
    public void save(@RequestBody Subscribe subscribe) {
        logger.debug("/sub/save>>>>subscribe="+ JSON.toJSONString(subscribe));
        try {
            subscribeBiz.save(subscribe);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/sub/save>>>>保存成功");
    }

    @PostMapping("findSubByPage")
    public List<Subscribe> findSubByPage(@RequestBody SubscribePageDTO subscribePageDTO) {
        logger.debug("/sub/findSubByPage>>>>subscribePageDTO="+ JSON.toJSONString(subscribePageDTO));

        List<Subscribe> list = new ArrayList<Subscribe>();
        try {
           list = subscribeBiz.findSubByPage(subscribePageDTO);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return list;
    }

    @PostMapping("findSubByCount")
    public Integer findSubByCount(@RequestBody SubscribePageDTO subscribePageDTO) {
        logger.debug("/sub/findSubByCount>>>>subscribePageDTO="+ JSON.toJSONString(subscribePageDTO));

        Integer count = -1;
        try {
            count = subscribeBiz.findSubByCount(subscribePageDTO);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return count;
    }

}
