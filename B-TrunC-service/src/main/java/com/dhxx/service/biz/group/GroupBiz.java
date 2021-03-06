package com.dhxx.service.biz.group;

import com.dhxx.common.entity.dto.GrpPageDTO;
import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.service.mapper.group.GroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author liangz
 * Date 2017-9-29
 * @version 1.01
 */
@Service
@Transactional
public class GroupBiz {
    private static Logger logger = LoggerFactory.getLogger(GroupBiz.class);

    @Autowired
    private GroupMapper groupMapper;


    //新增
    public GroupInfo save(GroupInfo group) {
        GroupInfo groupInfo = null;
        int grpId =Integer.valueOf(groupMapper.findGrpIdIsMax().getGrpId()) + 1;
        group.setGrpId(String.valueOf(grpId));
        group.setCreateTime(new Date());
        try {
            groupMapper.save(group);
            groupInfo = groupMapper.findGrpInfoById(group.getId());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return groupInfo;
    }

    //删除
    public void delete(GroupInfo group) { groupMapper.delete(group); }

    //修改
    public  void update(GroupInfo group) { groupMapper.update(group); }

    //组 分页
    public List<GroupInfo> findGrpByPage(GrpPageDTO grpPageDTO){
        return groupMapper.findGrpByPage(grpPageDTO);
    }

     //组总页数
    public Integer findGrpByCount(GrpPageDTO grpPageDTO){
        double count = groupMapper.findGrpByCount(grpPageDTO);
        int totalPages = (int) Math.ceil(count/ grpPageDTO.getPageSize());
        return totalPages;
    }

    //查找群组信息
    public GroupInfo findGrpInfoByGrpId(String grpId){ return groupMapper.findGrpInfoByGrpId(grpId); }

    //查找用户管理组配置
    public List<GroupInfo> findGrpInfoAndSub(GrpPageDTO grpPageDTO){ return groupMapper.findGrpInfoAndSub(grpPageDTO); }

    //查找用户管理组配置总页数
    public Integer findGrpInfoAndSubCount(GrpPageDTO grpPageDTO){
        double count = groupMapper.findGrpInfoAndSubCount(grpPageDTO);
        int totalPages = (int) Math.ceil(count/ grpPageDTO.getPageSize());
        return totalPages;
    }
}
