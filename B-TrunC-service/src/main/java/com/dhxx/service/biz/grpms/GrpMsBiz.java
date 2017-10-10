package com.dhxx.service.biz.grpms;

import com.dhxx.common.entity.group.GroupInfo;
import com.dhxx.common.entity.grpms.GroupMs;
import com.dhxx.service.mapper.grpms.GrpMsMapper;
import com.sun.codemodel.internal.JForEach;
import org.omg.PortableServer.ForwardRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public String queryMenuByUdn(String udn) {
        List<GroupMs> list = new ArrayList<GroupMs>();
        List<GroupMs> msList = new ArrayList<GroupMs>();
        StringBuffer strJson = new StringBuffer();
        list = grpMsMapper.queryGrpMsByUdn(udn);

        if (list != null && list.size() > 0) {
            strJson.append("{'success': true,'data':[");
            for (int i = 0; i < list.size(); i++) {
                strJson.append("{'grpId':'").append(list.get(i).getGrpId())
                        .append("','grpName':'").append(list.get(i).getGrpName())
                        .append("','msList':[");

                msList = grpMsMapper.queryGrpMsByGrpId(list.get(i).getGrpId(), udn);

                for (int j = 0; j < msList.size(); j++) {
                    strJson.append("{'udn':'").append(msList.get(j).getUdn())
                            .append("','userName':'").append(msList.get(j).getUserName())
                            .append("'}");
                }

                strJson.append("]},");
            }

            strJson.append("]}");
        }
        String str = null;
        int index = strJson.toString().lastIndexOf(",");
        if (index != -1) {
            str = strJson.toString().substring(0, index)
                    + strJson.toString().substring(index + 1, strJson.toString().length());
        }
        str = str.replaceAll("\'", "\"");

        return str;
    }
}
