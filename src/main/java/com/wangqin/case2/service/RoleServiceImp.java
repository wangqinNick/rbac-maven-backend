package com.wangqin.case2.service;

import com.wangqin.case2.dao.RoleMapper;
import com.wangqin.case2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class RoleServiceImp implements RoleService{
    /**
     * 赋予指定用户角色
     *
     * @param userId 用户id
     * @param roleId 角色id
     */
    @Override
    public void assign(int userId, int roleId) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            mapper.assign(userId, roleId);
        } finally {
            SqlSessionUtil.commitAndClose(sqlSession);
        }
    }
}
