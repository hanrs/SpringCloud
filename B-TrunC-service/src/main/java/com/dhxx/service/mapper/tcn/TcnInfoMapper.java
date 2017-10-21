package com.dhxx.service.mapper.tcn;

import com.dhxx.common.entity.tcn.TcnInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author liangz
 * Date: 2017-9-28
 * @version 1.01
 */
public interface TcnInfoMapper {

    void save(TcnInfo tsc);   //增

    void delete(TcnInfo tsc); //删

    void update(TcnInfo tsc); //改

    TcnInfo tcnInfoByAccount(TcnInfo tsc); //根据账号查找核心网信息
}
