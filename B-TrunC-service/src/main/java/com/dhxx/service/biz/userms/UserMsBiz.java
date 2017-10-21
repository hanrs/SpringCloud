package com.dhxx.service.biz.userms;

import com.dhxx.common.entity.usergrp.UserGrp;
import com.dhxx.common.entity.userms.UserMs;
import com.dhxx.service.mapper.usergrp.UserGrpMapper;
import com.dhxx.service.mapper.userms.UserMsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> 类说明 </p>
 * @author liangz
 * Date: 2017年10月20日
 * @version 1.01
 */
@Service
@Transactional
public class UserMsBiz {

    private static Logger logger = LoggerFactory.getLogger(UserMsBiz.class);

    @Autowired
    private UserMsMapper userMsMapper;

    //新增
    public void save(UserMs userMs) { userMsMapper.save(userMs); }


    //修改
    public  void update(UserMs userMs) { userMsMapper.update(userMs); }
}
