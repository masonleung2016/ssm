package com.springboot.common.utils;

import com.springboot.common.utils.HttpUtils;
import com.springboot.common.utils.IPUtils;
import com.springboot.common.utils.MD5Utils;
import com.springboot.common.utils.UUIDUtils;

/**
 * @Author: LCF
 * @Date: 2020/1/2 17:15
 * @Package: com.springboot.common.utils
 */

public class AppToken {

    public static synchronized String generateToken() {

        StringBuilder token = new StringBuilder();
        token.append(HttpUtils.getSession().getId());
        token.append("_");
        token.append(UUIDUtils.generateUUID());
        token.append("_");
        token.append(IPUtils.getIpAddr(HttpUtils.getRequest()));
        return MD5Utils.getMD5AndBase64(token.toString());

    }

}
