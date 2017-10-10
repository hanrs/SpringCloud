package com.dhxx.service.mapper.ms;

import com.dhxx.common.entity.ms.MsInfo;
import com.dhxx.common.entity.vo.MsPageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liangz
 * Date: 2017-9-28
 * @version 1.01
 */
public interface MsMapper {

    void save(MsInfo ms);   //增

    void delete(MsInfo ms); //删

    void update(MsInfo ms); //改

    MsInfo findMsByUdn(@Param("udn") String udn); //根据udn查找终端信息

    List<MsInfo> findMsByPage(MsPageVo msPageVo); //查询指定群组、指定页的终端用户信息

    Double findMsByCount(MsPageVo msPageVo); //查询全部终端或指定群组下的终端总页数

    List<MsInfo> findMsOnManage(MsPageVo msPageVo); //查询指定页的终端用户信息   用于用户管理

    Double findMsOnManageCount(MsPageVo msPageVo); //查询全部终端总页数   用于用户管理

}
