package com.wangqin.case2.service;

import com.wangqin.case2.dao.UserMapper;
import com.wangqin.case2.pojo.po.User;
import com.wangqin.case2.pojo.vo.AddUser;
import com.wangqin.case2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger("UserService");

    /**
     * 添加用户
     *
     * @param user 新用户
     * @return 是否添加成功
     */
    @Override
    public Boolean add(AddUser user) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User u = mapper.query(user);
            if (u == null) {
                mapper.add(user);
                LOGGER.info("用户添加成功");
                return true;
            } else {
                LOGGER.info("用户添加失败");
                return false;
            }
        } finally {
            SqlSessionUtil.commitAndClose(sqlSession);
        }
    }
}
