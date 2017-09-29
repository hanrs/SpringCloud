package com.dhxx.service.mapper.ms;

import com.dhxx.common.entity.ms.MsInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author liangz
 * Date: 2017-9-28
 * @version 1.01
 */
public interface MsMapper {

    void save(MsInfo ms);   //增

    void delete(MsInfo ms); //删

    void update(MsInfo ms); //改

    MsInfo MsInfoByUdn(@Param("udn") String udn); //根据UDN查找终端信息
}
