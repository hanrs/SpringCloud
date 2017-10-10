package com.dhxx.service.rest.ms;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.ms.MsInfo;
import com.dhxx.common.entity.vo.MsPageVo;
import com.dhxx.service.biz.ms.MsBiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangz
 * Date 2017-9-28
 * @version 1.01
 */
@RestController
@RequestMapping("ms")
public class MsController {
    private static Logger logger = LoggerFactory.getLogger(MsController.class);

    @Autowired
    private MsBiz msBiz;

    @PostMapping("/save")
    public void save(@RequestBody MsInfo ms) {
        logger.debug("/ms/save>>>>ms="+ JSON.toJSONString(ms));
        try {
            msBiz.save(ms);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/ms/save>>>>保存成功");
    }

    @PostMapping("update")
    public void update(@RequestBody MsInfo ms) {
        logger.debug("/ms/update>>>>ms="+ JSON.toJSONString(ms));
        try {
            msBiz.update(ms);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("delete")
    public void delete(@RequestBody MsInfo ms) {
        logger.debug("/ms/delete>>>>ms="+ JSON.toJSONString(ms));
        try {
            msBiz.delete(ms);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("findMsByUdn")
    public MsInfo findMsByUdn(@RequestBody MsInfo ms) {
        logger.debug("/ms/findMsByUdn>>>>ms="+ JSON.toJSONString(ms));
        MsInfo msInfo = null;
        try {
            msInfo = msBiz.findMsByUdn(ms.getUdn());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }

        return msInfo;
    }

    @PostMapping("findMsByPage")
    public List<MsInfo> findMsByPage(@RequestBody MsPageVo msPageVo) {
        logger.debug("/ms/findMsByPage>>>>msPageVo="+ JSON.toJSONString(msPageVo));
        List<MsInfo> list = new ArrayList<MsInfo>();
        try {
            list = msBiz.findMsByPage(msPageVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }

        return list;
    }

    @PostMapping("findMsByCount")
    public Integer findMsByCount(@RequestBody MsPageVo msPageVo) {
        logger.debug("/ms/findMsByPage>>>>msPageVo="+ JSON.toJSONString(msPageVo));
        int totalPages = -1;
        try {
            totalPages = msBiz.findMsByCount(msPageVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return totalPages;
    }

    @PostMapping("findMsOnManage")
    public List<MsInfo> findMsOnManage(@RequestBody MsPageVo msPageVo) {
        logger.debug("/ms/findMsOnManage>>>>msPageVo="+ JSON.toJSONString(msPageVo));
        List<MsInfo> list = new ArrayList<MsInfo>();
        try {
            list = msBiz.findMsOnManage(msPageVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }

        return list;
    }

    @PostMapping("findMsOnManageCount")
    public Integer findMsOnManageCount(@RequestBody MsPageVo msPageVo) {
        logger.debug("/ms/findMsOnManageCount>>>>msPageVo="+ JSON.toJSONString(msPageVo));
        int totalPages = -1;
        try {
            totalPages = msBiz.findMsOnManageCount(msPageVo);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return totalPages;
    }
}
