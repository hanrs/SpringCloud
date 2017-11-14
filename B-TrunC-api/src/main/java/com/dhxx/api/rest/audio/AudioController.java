package com.dhxx.api.rest.audio;

import com.dhxx.api.rpc.audio.AudioFeignClient;
import com.dhxx.common.entity.audio.AudioVideo;
import com.dhxx.common.entity.dto.AudioPageDTO;
import com.dhxx.common.utils.Resp;
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

    @Autowired
    private AudioFeignClient audioFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody AudioVideo audioVideo) throws Exception {
        try {
            audioFeignClient.save(audioVideo);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(audioVideo);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody List<AudioVideo> audioVideos) throws  Exception {
        try {
            audioFeignClient.delete(audioVideos);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(audioVideos);
    }

    @PostMapping("findAudioVideoByPage")
    public Object findAudioVideoByPage(@RequestBody AudioPageDTO audioPageDTO) throws  Exception {
        List<AudioVideo> list = new ArrayList<AudioVideo>();
        try {
            list = audioFeignClient.findAudioVideoByPage(audioPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(list);
    }

    @PostMapping("findCallLogByCount")
    public Object findAudioVideoByCount(@RequestBody AudioPageDTO audioPageDTO) throws  Exception {
        int count = -1;
        try {
            count = audioFeignClient.findAudioVideoByCount(audioPageDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Resp.SUCCESS(count);
    }

}
