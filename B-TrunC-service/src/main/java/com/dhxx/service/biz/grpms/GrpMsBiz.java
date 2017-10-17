package com.dhxx.service.biz.grpms;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.common.entity.grpms.GroupMs;
import com.dhxx.common.utils.JsonUtil;
import com.dhxx.service.mapper.group.GroupMapper;
import com.dhxx.service.mapper.grpms.GrpMsMapper;
import com.sun.codemodel.internal.JForEach;
import org.omg.PortableServer.ForwardRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangz
 * Date 2017-9-29
 * @version 1.01
 */
@Service
@Transactional
public class GrpMsBiz {
    private static Logger logger = LoggerFactory.getLogger(GrpMsBiz.class);

    @Autowired
    private GrpMsMapper grpMsMapper;

    @Autowired
    private GroupMapper groupMapper;

    //新增
    public void save(GroupMs groupMs) {
        grpMsMapper.save(groupMs);
    }

    //删除
    public void delete(GroupMs groupMs) {
        grpMsMapper.delete(groupMs);
    }

    //修改
    public void update(GroupMs groupMs) {
        grpMsMapper.update(groupMs);
    }

    //组装菜单JSON
    public JSONObject queryMenuByUdn(String udn) {
        List<GroupMs> list = grpMsMapper.queryGrpMsByUdn(udn);  //用户所有群组
        StringBuffer strJson = new StringBuffer();

        JSONObject perObject = new JSONObject();
        JSONArray dataArray= new JSONArray();
        JSONObject jsonObject = new JSONObject();

        if (list != null && list.size() > 0) {
            perObject.put("success","true");

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPgrpId().equals("0")) {  //如果这群组是一级群组
                    jsonObject = menuJson(strJson,list.get(i).getGrpId(),list.get(i).getGrpName(),udn,null);
                    dataArray.add(jsonObject);
                } else {    //二级群组
                    //根据一级群组搜索隶属的二级群组
                    GroupInfo groupInfo = groupMapper.findGrpInfoByGrpId(list.get(i).getPgrpId());
                    jsonObject=menuJson(strJson,groupInfo.getGrpId(),groupInfo.getGrpName(),udn,list.get(i).getPgrpId());
                    dataArray.add(jsonObject);
                }
            }
        }
        perObject.put("data",dataArray);
        return perObject;
    }

    private JSONObject menuJson(StringBuffer strJson,String grpId, String grpName,String udn,String pgrpId){
        JSONObject jsonObject = new JSONObject();
        JSONArray childArray= new JSONArray();

        List<GroupInfo> childList = new ArrayList<>();
        List<GroupMs> msList = grpMsMapper.queryGrpMsByGrpId(grpId, udn);    //群组下的用户集合
        jsonObject.put("grpId",grpId);
        jsonObject.put("grpName",grpName);

        if(msList.size() > 0) {
            jsonObject.put("msList",msList);
        }

        //根据一级群组搜索隶属的二级群组
        if(pgrpId==null) {  //一级群组
             childList = groupMapper.findGrpInfoByPGrpId(grpId);
        }else { //二级群组
             childList = groupMapper.findGrpInfoByPGrpId(pgrpId);
        }
        if(childList.size()>0) {
            for (int i = 0; i < childList.size(); i++) {
                JSONObject childJsonObject = new JSONObject();
                childJsonObject.put("grpId",childList.get(i).getGrpId());
                childJsonObject.put("grpName",childList.get(i).getGrpName());
                msList = grpMsMapper.queryGrpMsByGrpId(childList.get(i).getGrpId(), udn);
                if(msList!=null && msList.size()>0){
                    childJsonObject.put("msList",msList);
                }
                childArray.add(childJsonObject);
            }
            jsonObject.put("childList",childArray);
        }

        String json = jsonObject.toJSONString();
        System.out.print(json);
        return jsonObject;
    }
}
