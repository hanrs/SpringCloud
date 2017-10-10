package com.dhxx.service.biz.group;

import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.common.entity.vo.GrpPageVo;
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
    public void save(GroupInfo group) {
        group.setCreateTime(new Date());
        groupMapper.save(group);
    }

    //删除
    public void delete(GroupInfo group) { groupMapper.delete(group); }

    //修改
    public  void update(GroupInfo group) { groupMapper.update(group); }

    //组 分页
    public List<GroupInfo> findGrpByPage(GrpPageVo grpPageVo){
        return groupMapper.findGrpByPage(grpPageVo);
    }

    //组总页数
    public Integer findGrpByCount(GrpPageVo grpPageVo){
        double count = groupMapper.findGrpByCount(grpPageVo);
        int totalPages = (int) Math.ceil(count/grpPageVo.getPageSize());
        return totalPages;
    }

}
