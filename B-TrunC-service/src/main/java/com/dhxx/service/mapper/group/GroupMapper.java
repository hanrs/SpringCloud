package com.dhxx.service.mapper.group;

import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.common.entity.vo.GrpPageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liangz
 * Date 2017-9-29
 * @version 1.01
 */
public interface GroupMapper {
    void save(GroupInfo group); //增

    void delete(GroupInfo group); //删

    void update(GroupInfo group); //改

    List<GroupInfo> findGrpByPage(GrpPageVo grpPageVo); //组分页

    Double findGrpByCount(GrpPageVo grpPageVo); //组 总记录

    List<GroupInfo> findGrpInfoByPGrpId(@Param("pgrpId") String pgrpId);//根据一级群组搜索隶属的二级群组

    GroupInfo findGrpInfoByGrpId(@Param("grpId") String grpId); //根据grpId查找对象

    GroupInfo findGrpIdIsMax(); //查最大的grpId

    GroupInfo findGrpInfoById(@Param("id") Long id); //根据Id查找对象

    List<GroupInfo> findGrpInfoAndSub(GrpPageVo grpPageVo); //查找用户管理组配置

    Double findGrpInfoAndSubCount(GrpPageVo grpPageVo); //查找用户管理组配置 总记录
}
