package com.wangqin.case2.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *   FastJson
 * */
public class BaseController {

    /**
     * 将Object对象obj转为JSON格式, 并响应给浏览器
     *
     * @param response 服务器响应
     * @param obj      Object对象
     * @throws IOException ParseException
     */
    public static void printResult(HttpServletResponse response, Object obj) throws IOException {
        response.setContentType("application/json;charset=utf8");// 设置返回类型
        JSON.writeJSONString(response.getWriter(), obj);
    }

    /**
     * 把JSON格式的表单数据直接转成T类型的对象
     *
     * @param request 浏览器请求
     * @param tClass  T类的Class对象
     * @param <T>     T类泛型
     * @return T类型的对象
     * @throws IOException ParseException
     */
    public static <T> T parseJSON2Object(HttpServletRequest request, Class<T> tClass) throws IOException {
        // 把JSON格式的表单数据直接转成T类型的对象
        return JSON.parseObject(request.getInputStream(), tClass);
    }
}
