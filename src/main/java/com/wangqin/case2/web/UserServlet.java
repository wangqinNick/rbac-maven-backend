package com.wangqin.case2.web;

import com.wangqin.case2.pojo.vo.AddUser;
import com.wangqin.case2.service.UserService;
import com.wangqin.case2.service.UserServiceImpl;
import com.wangqin.case2.utils.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 匹配所有以user开始, 用户相关服务
// 如: /user/findAll    查找所有用户
//     /user/update     更新用户信息
//     /user/add        添加用户
//     /user/delete     删除用户
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private static final long serialVersionUID = -3966016499318032278L;
    private static final Logger LOGGER = LoggerFactory.getLogger("UserServlet");

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("delete");
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info("收到添加用户请求");
        AddUser user = BaseController.parseJSON2Object(request, AddUser.class);

        UserService userService = new UserServiceImpl();
        boolean result = userService.add(user);
        System.out.println(user);
        BaseController.printResult(response, result);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("update");
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("findAll");
    }
}