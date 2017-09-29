package com.dhxx.api.rest.ms;

import com.dhxx.api.rpc.ms.MsFeignClient;
import com.dhxx.common.entity.ms.MsInfo;
import com.dhxx.common.utils.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangz
 * Date 2017-9-28
 * @version 1.01
 */
@RestController
@RequestMapping("ms")
public class MsController {

    @Autowired
    private MsFeignClient msFeignClient;

    @PostMapping("save")
    public Object save(@RequestBody MsInfo ms) throws Exception {
        try {
            msFeignClient.save(ms);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(ms);
    }

    @PostMapping("update")
    public Object update(@RequestBody MsInfo ms) throws  Exception {
        try {
            msFeignClient.update(ms);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(ms);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody MsInfo ms) throws  Exception {
        try {
            msFeignClient.delete(ms);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(ms);
    }
}
