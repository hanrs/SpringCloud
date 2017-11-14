package com.dhxx.service.biz.ms;

import com.dhxx.common.entity.dto.MsPageDTO;
import com.dhxx.common.entity.ms.MsInfo;
import com.dhxx.service.mapper.ms.MsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liangz
 * Date 2017-9-28
 * @version 1.01
 */
@Service
@Transactional
public class MsBiz {
    private static Logger logger = LoggerFactory.getLogger(MsBiz.class);

    @Autowired
    private MsMapper msMapper;

    //新增终端
    public void save(MsInfo ms) {
        ms.setOnlineStatus(2);
        ms.setStatus(0);
        ms.setType("DC调度台");
        ms.setIsTCN(0);
        ms.setIsSubGroup(0);
        ms.setIsSubRegister(0);
        msMapper.save(ms);
    }

    //删除终端
    public void delete(MsInfo ms) { msMapper.delete(ms); }

    //修改终端
    public  void update(MsInfo ms) { msMapper.update(ms); }

    //根据udn查找终端信息
    public MsInfo findMsByUdn(String udn) { return msMapper.findMsByUdn(udn); }

    //查询指定群组、指定页的终端用户信息
    public List<MsInfo> findMsByPage(MsPageDTO msPageDTO) {
        List list = msMapper.findMsByPage(msPageDTO);
        return list;
    }

    //查询全部终端或指定群组下的终端总页数
    public Integer findMsByCount(MsPageDTO msPageDTO) {
        Double count = msMapper.findMsByCount(msPageDTO);
        int totalPages = (int) Math.ceil(count/ msPageDTO.getPageSize());
        return totalPages;
    }

    //查询指定页的终端用户信息   用于用户管理
    public List<MsInfo> findMsOnManage(MsPageDTO msPageDTO) {
        List list = msMapper.findMsOnManage(msPageDTO);
        return list;
    }

    //查询全部终端总页数   用于用户管理
    public Integer findMsOnManageCount(MsPageDTO msPageDTO) {
        Double count = msMapper.findMsOnManageCount(msPageDTO);
        int totalPages = (int) Math.ceil(count/ msPageDTO.getPageSize());
        return totalPages;
    }
}
