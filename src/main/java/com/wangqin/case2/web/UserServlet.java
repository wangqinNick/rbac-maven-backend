package com.wangqin.case2.web;

import com.wangqin.case2.pojo.vo.AddUser;
import com.wangqin.case2.pojo.vo.PageResult;
import com.wangqin.case2.pojo.vo.QueryPageBean;
import com.wangqin.case2.pojo.vo.Result;
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

    public void add(HttpServletRequest request, HttpServletResponse response) {
        try {
            AddUser user = BaseController.parseJSON2Object(request, AddUser.class);
            UserService userService = new UserServiceImpl();
            boolean addResult = userService.add(user);
            Result result;
            if (addResult) {
                result = new Result(true, "添加成功");
            } else {
                result = new Result(false, "用户已存在, 添加失败");
            }
            BaseController.printResult(response, result);
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
            // 6. 创建Result对象失败
            Result result = new Result(false, "添加失败");
            try {
                BaseController.printResult(response, result);
            } catch (IOException ex) {
                LOGGER.error(ex.getMessage());
            }
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("update");
    }

    public void pagingQuery(HttpServletRequest request, HttpServletResponse response) {
        // 1. 将前端提交的参数(当前页码, 每页条数)封装到VO实体类QueryPageBean中
        // 要求前端JSON的key和JavaBean中的成员变量一致
        try {
            QueryPageBean queryPageBean = BaseController.parseJSON2Object(request, QueryPageBean.class);
            // 2. 创建业务层对象
            UserService userService = new UserServiceImpl();
            // 3. 调用业务层方法, 将结果封装到PageResult
            PageResult pageResult = userService.pagingQuery(queryPageBean);
            // 4. 创建Result对象, 继续封装
            Result result = new Result(true, "查询成功", pageResult);
            // 5. 将result转化为JSON之后响应给前端
            BaseController.printResult(response, result);
        } catch (IOException e) {
            LOGGER.warn(e.getMessage());
            // 6. 创建Result对象失败
            Result result = new Result(false, "查询失败");
            try {
                BaseController.printResult(response, result);
            } catch (IOException ex) {
                LOGGER.error(ex.getMessage());
            }
        }
    }
}