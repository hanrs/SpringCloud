package com.dhxx.service.mapper.subscribe;


import com.dhxx.common.entity.dto.SubscribePageDTO;
import com.dhxx.common.entity.subscribe.Subscribe;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-9
 * @version 1.01
 */
public interface SubscribeMapper {
    void save(Subscribe subscribe); //增

    List<Subscribe> findSubByPage(SubscribePageDTO subscribeVo); //订阅查询

    Double findSubByCount(SubscribePageDTO subscribeVo); //订阅记录查询 总记录

}
