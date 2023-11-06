package com.wangqin.case2.dao;


import com.wangqin.case2.pojo.po.User;
import com.wangqin.case2.pojo.vo.AddUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 查询用户表的总记录数
     *
     * @return 总记录数
     */
    @Select("SELECT COUNT(*) FROM t_user")
    public Long count();

    /**
     * 分页查询
     *
     * @param startIndex 查询页码
     * @param pageSize   每页记录数
     * @return 查询页的用户记录
     */
    public List<User> pagingQuery(@Param("startIndex") Integer startIndex,
                                  @Param("pageSize") Integer pageSize);
}
