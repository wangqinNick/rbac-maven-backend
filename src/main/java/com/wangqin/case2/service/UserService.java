package com.wangqin.case2.service;

import com.wangqin.case2.pojo.vo.AddUser;
import com.wangqin.case2.pojo.vo.PageResult;
import com.wangqin.case2.pojo.vo.QueryPageBean;

public interface UserService {

    /**
     * 添加用户
     * @param user 新用户
     * @return 是否添加成功
     */
    public Boolean add(AddUser user);

    /**
     * 查询全部用户信息
     * @return 封装JavaBean对象
     */
    public PageResult pagingQuery(QueryPageBean queryPageBean);
}
