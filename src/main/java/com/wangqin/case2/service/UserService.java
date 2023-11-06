package com.wangqin.case2.service;

import com.wangqin.case2.pojo.vo.AddUser;

public interface UserService {

    /**
     * 添加用户
     * @param user 新用户
     * @return 是否添加成功
     */
    public Boolean add(AddUser user);
}
