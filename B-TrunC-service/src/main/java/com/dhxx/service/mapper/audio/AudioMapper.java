package com.dhxx.service.mapper.audio;

import com.dhxx.common.entity.audio.AudioVideo;
import com.dhxx.common.entity.vo.AudioPageVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-9
 * @version 1.01
 */
public interface AudioMapper {
    void save(AudioVideo audioVideo); //增

    void delete(AudioVideo audioVideo); //删

    List<AudioVideo> findAudioVideoByPage(AudioPageVo audioPageVo); //音像记录分页按条件查询

    Double findAudioVideoByCount(AudioPageVo audioPageVo); //音像记录查询 总记录
}
