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

}
