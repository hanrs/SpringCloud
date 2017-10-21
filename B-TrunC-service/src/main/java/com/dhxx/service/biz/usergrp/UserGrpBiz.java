package com.dhxx.service.biz.usergrp;

import com.dhxx.common.entity.usergrp.UserGrp;
import com.dhxx.service.mapper.usergrp.UserGrpMapper;
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
public class UserGrpBiz {

    private static Logger logger = LoggerFactory.getLogger(UserGrpBiz.class);

    @Autowired
    private UserGrpMapper userGrpMapper;

    //新增
    public void save(UserGrp userGrp) { userGrpMapper.save(userGrp); }


    //修改
    public  void update(UserGrp userGrp) { userGrpMapper.update(userGrp); }
}
