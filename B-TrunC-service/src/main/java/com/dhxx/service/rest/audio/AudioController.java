package com.dhxx.service.rest.audio;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.audio.AudioVideo;
import com.dhxx.common.entity.vo.AudioPageVo;
import com.dhxx.service.biz.audio.AudioBiz;
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
 * Date 2017-10-09
 * @version 1.01
 */
@RestController
@RequestMapping("audio")
public class AudioController {
    private static Logger logger = LoggerFactory.getLogger(AudioController.class);

    @Autowired
    private AudioBiz audioBiz;

    @PostMapping("/save")
    public void save(@RequestBody AudioVideo audioVideo) {
        logger.debug("/audio/save>>>>audioVideo="+ JSON.toJSONString(audioVideo));
        try {
            audioBiz.save(audioVideo);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
        logger.debug("/audio/save>>>>保存成功");
    }


    @PostMapping("delete")
    public void delete(@RequestBody AudioVideo audioVideo) {
        logger.debug("/audio/delete>>>>audioVideo="+ JSON.toJSONString(audioVideo));
        try {
            audioBiz.delete(audioVideo);
        }catch (Exception e){
            logger.error(e.getMessage());
            return;
        }
    }

    @PostMapping("findAudioVideoByPage")
    public List<AudioVideo> findAudioVideoByPage(@RequestBody AudioPageVo audioPageVo) {
        logger.debug("/audio/findAudioVideoByPage>>>>audioPageVo="+ JSON.toJSONString(audioPageVo));

        List<AudioVideo> list = new ArrayList<AudioVideo>();
        try {
           list = audioBiz.findAudioVideoByPage(audioPageVo);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return list;
    }

    @PostMapping("findAudioVideoByCount")
    public Integer findAudioVideoByCount(@RequestBody AudioPageVo audioPageVo) {
        logger.debug("/audio/findAudioVideoByCount>>>>audioPageVo="+ JSON.toJSONString(audioPageVo));

        Integer count = -1;
        try {
            count = audioBiz.findAudioVideoByCount(audioPageVo);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

        return count;
    }

}
