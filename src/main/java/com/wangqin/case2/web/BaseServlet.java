package com.wangqin.case2.web;

import com.wangqin.case2.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 不需要被访问
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1016282327639045386L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = ServletUtil.getMethodName(request);
        // 使用反射通用框架
        try {
            Class<?> cls = this.getClass();                                                                     // 1. 获取Class对象
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);     // 2. 获取成员方法
            method.invoke(this, request, response);                                                         // 3. 调用方法
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}