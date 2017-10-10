package com.dhxx.service.mapper.grpms;

import com.dhxx.common.entity.grpms.GroupMs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liangz
 * Date 2017-9-29
 * @version 1.01
 */
public interface GrpMsMapper {
    void save(GroupMs groupMs); //增

    void delete(GroupMs groupMs); //删

    void update(GroupMs groupMs); //改

    List<GroupMs> queryGrpMsByUdn(@Param("udn") String udn); //根据UDN来查找用户群组

    List<GroupMs> queryGrpMsByGrpId(@Param("grpId") String grpId, @Param("udn") String udn); //根据grpId来查找用户集
}
