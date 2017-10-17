package com.dhxx.service.biz.audio;

import com.dhxx.common.entity.audio.AudioVideo;
import com.dhxx.common.entity.vo.AudioPageVo;
import com.dhxx.service.mapper.audio.AudioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 */
@Service
@Transactional
public class AudioBiz {
    private static Logger logger = LoggerFactory.getLogger(AudioBiz.class);

    @Autowired
    private AudioMapper audioMapper;

    //新增
    public void save(AudioVideo audioVideo) { audioMapper.save(audioVideo); }

    //删除
    public void delete(List<AudioVideo> audioVideos) {
        for (int i = 0; i <audioVideos.size(); i++ ) {
            audioMapper.delete(audioVideos.get(i));
        }

    }

    //音像记录分页按条件查询
    public List<AudioVideo> findAudioVideoByPage(AudioPageVo audioPageVo) {
        return audioMapper.findAudioVideoByPage(audioPageVo);
    }

    //音像记录查询 总页数
    public Integer findAudioVideoByCount(AudioPageVo audioPageVo) {
         double count = audioMapper.findAudioVideoByCount(audioPageVo);
        int totalPages = (int) Math.ceil(count/audioPageVo.getPageSize());
        return totalPages;
    }

}
