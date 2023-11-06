package com.wangqin.case2.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {


    @Insert("INSERT INTO t_user_role (user_id, role_id) VALUES (#{userId}, #{roleId})")
    public void assign(@Param("userId") int userId, @Param("roleId") int roleId);
}
