package com.dhxx.api.rest.subscribe;

import com.dhxx.api.rpc.subscribe.SubsctibeFeignClient;
import com.dhxx.common.entity.subscribe.Subscribe;
import com.dhxx.common.entity.vo.SubscribePageVo;
import com.dhxx.common.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangz
 * Date 2017-10-21
 * @version 1.01
 */
@RestController
@RequestMapping("sub")
public class SubscribeController {

    @Autowired
    private SubsctibeFeignClient subsctibeFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody Subscribe subscribe) throws Exception {
        try {
            subsctibeFeignClient.save(subscribe);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(subscribe);
    }

    @PostMapping("findSubByPage")
    public Object findSubByPage(@RequestBody SubscribePageVo subscribePageVo) throws  Exception {
        List<Subscribe> list = new ArrayList<Subscribe>();
        try {
            list = subsctibeFeignClient.findSubByPage(subscribePageVo);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("findSubByCount")
    public Object findSubByCount(@RequestBody SubscribePageVo subscribePageVo) throws  Exception {
        int count = -1;
        try {
            count = subsctibeFeignClient.findSubByCount(subscribePageVo);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }

}
