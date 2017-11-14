package com.dhxx.service.biz.subscribe;

import com.dhxx.common.entity.dto.SubscribePageDTO;
import com.dhxx.common.entity.subscribe.Subscribe;
import com.dhxx.service.mapper.subscribe.SubscribeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-21
 * @version 1.01
 */
@Service
@Transactional
public class SubscribeBiz {
    private static Logger logger = LoggerFactory.getLogger(SubscribeBiz.class);

    @Autowired
    private SubscribeMapper subscribeMapper;

    //新增
    public void save(Subscribe subscribe) { subscribeMapper.save(subscribe); }


    //订阅记录分页按条件查询
    public List<Subscribe> findSubByPage(SubscribePageDTO subscribePageDTO) {
        return subscribeMapper.findSubByPage(subscribePageDTO);
    }

    //订阅记录查询 总记录
    public Integer findSubByCount(SubscribePageDTO subscribePageDTO) {
        double count =  subscribeMapper.findSubByCount(subscribePageDTO);
        int totalPages = (int) Math.ceil(count/ subscribePageDTO.getPageSize());
        return totalPages;
    }

}
