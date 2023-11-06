package com.wangqin.case2.service;

public interface RoleService {

    /**
     * 赋予指定用户角色
     * @param userId 用户Id
     * @param roleId 角色Id
     */
    public void assign(int userId, int roleId);
}
