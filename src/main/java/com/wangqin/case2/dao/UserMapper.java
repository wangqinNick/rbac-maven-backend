package com.wangqin.case2.dao;


import com.wangqin.case2.pojo.po.User;
import com.wangqin.case2.pojo.vo.AddUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 查询用户
     *
     * @param user 被查询用户
     * @return 若找到用户, 返回该用户对象, 否则返回null
     */
    @Select("SELECT * FROM t_user WHERE username = #{username}")
    public User query(AddUser user);

    /**
     * 添加用户
     *
     * @param user 待添加用户
     * @return 是否添加成功
     */
    @Options(useGeneratedKeys = true,
            keyColumn = "id",
            keyProperty = "id")
    @Insert("INSERT INTO t_user (username, password, remark, email, createTime, updateTime) " +
            "VALUES (#{username}, #{password}, #{remark}, #{email}, NOW(), NOW())")
    public boolean add(AddUser user);
}
