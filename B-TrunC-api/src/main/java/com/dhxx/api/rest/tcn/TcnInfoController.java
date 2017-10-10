package com.dhxx.api.rest.tcn;

import com.dhxx.api.rpc.tcn.TcnInfoFeignClient;
import com.dhxx.common.entity.tcn.TcnInfo;
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
@RequestMapping("tcn")
public class TcnInfoController {

    @Autowired
    private TcnInfoFeignClient tcninfoFeignClient;

    private String msg = null;
    private boolean isSuccess = true;

    @PostMapping("save")
    public Object save(@RequestBody TcnInfo tcn) throws Exception {
        try {
            tcninfoFeignClient.save(tcn);
            msg = "保存成功";
        }catch (Exception e) {
            e.printStackTrace();
            msg = "保存失败";
            isSuccess = false;
            return null;
        }

        return Resp.SUCCESS(isSuccess, msg, tcn);
    }

    @PostMapping("update")
    public Object update(@RequestBody TcnInfo tcn) throws  Exception {
        try {
            tcninfoFeignClient.update(tcn);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(tcn);
    }

    @PostMapping("delete")
    public Object delete(@RequestBody TcnInfo tcn) throws  Exception {
        try {
            tcninfoFeignClient.delete(tcn);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Resp.SUCCESS(tcn);
    }
}
