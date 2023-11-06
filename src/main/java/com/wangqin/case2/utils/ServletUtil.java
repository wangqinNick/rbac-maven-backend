package com.wangqin.case2.utils;

import javax.servlet.http.HttpServletRequest;

public class ServletUtil {

    /**
     * 获取URI的最后一部分
     * @param request /user/findAll
     * @return findAll
     */
    public static String getMethodName(HttpServletRequest request) {
        String uri = request.getRequestURI();   // /user/findAll
        return uri.substring(uri.lastIndexOf("/")+1);
    }
}
