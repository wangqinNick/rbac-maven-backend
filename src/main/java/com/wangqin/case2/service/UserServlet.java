package com.wangqin.case2.service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 匹配所有以user开始, 用户相关服务
// 如: /user/findAll    查找所有用户
//     /user/update     更新用户信息
//     /user/add        添加用户
//     /user/delete     删除用户
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private static final long serialVersionUID = -3966016499318032278L;

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("delete");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("add");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("update");
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("findAll");
    }
}