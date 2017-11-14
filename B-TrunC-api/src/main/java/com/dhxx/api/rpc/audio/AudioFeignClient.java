package com.dhxx.api.rpc.audio;

import com.alibaba.fastjson.JSON;
import com.dhxx.common.entity.audio.AudioVideo;
import com.dhxx.common.entity.dto.AudioPageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author liangz
 * Date 2017-10-09
 * @version 1.01
 */
@Primary
@FeignClient(name = "B-TrunC-service", fallback = AudioFeignClient.HystrixAudioFeignClientFallback.class)
public interface AudioFeignClient {

    @PostMapping("/B-TrunC-service/audio/save")
    public void save(AudioVideo audioVideo);

    @PostMapping("/B-TrunC-service/audio/delete")
    public void delete(List<AudioVideo> audioVideos);

    @PostMapping("/B-TrunC-service/audio/findAudioVideoByPage")
    public List<AudioVideo> findAudioVideoByPage(AudioPageDTO audioPageDTO);

    @PostMapping("/B-TrunC-service/audio/findAudioVideoByCount")
    public Integer findAudioVideoByCount(AudioPageDTO audioPageDTO);


    @Component
    static class HystrixAudioFeignClientFallback implements AudioFeignClient {

        private static final Logger log = LoggerFactory.getLogger(HystrixAudioFeignClientFallback.class);


        @Override
        public void save(AudioVideo audioVideo) {
            log.error("application=B-TrunC-service,url=/audio/save 异常发生，进入fallback方法，接收的参数：audioVideo = " + JSON.toJSONString(audioVideo));
            audioVideo.setId(-1L);
        }

        @Override
        public void delete(List<AudioVideo> audioVideos) {
            log.error("application=B-TrunC-service,url=/audio/delete 异常发生，进入fallback方法，接收的参数：audioVideo = " + JSON.toJSONString(audioVideos));
        }

        @Override
        public List<AudioVideo> findAudioVideoByPage(AudioPageDTO audioPageDTO) {
            log.error("application=B-TrunC-service,url=/audio/findAudioVideoByPage 异常发生，进入fallback方法，接收的参数：audioPageDTO = " + JSON.toJSONString(audioPageDTO));
            return null;
        }

        @Override
        public Integer findAudioVideoByCount(AudioPageDTO audioPageDTO) {
            log.error("application=B-TrunC-service,url=/audio/findAudioVideoByCount 异常发生，进入fallback方法，接收的参数：audioPageDTO = " + JSON.toJSONString(audioPageDTO));
            return -1;
        }

    }
}