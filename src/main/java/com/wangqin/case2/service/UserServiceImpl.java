package com.wangqin.case2.service;

import com.wangqin.case2.dao.UserMapper;
import com.wangqin.case2.pojo.po.User;
import com.wangqin.case2.pojo.vo.AddUser;
import com.wangqin.case2.pojo.vo.PageResult;
import com.wangqin.case2.pojo.vo.QueryPageBean;
import com.wangqin.case2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
                return true;
            } else {
                return false;
            }
        } finally {
            SqlSessionUtil.commitAndClose(sqlSession);
        }
    }

    /**
     * 查询全部用户信息
     *
     * @return 封装JavaBean对象
     */
    @Override
    public PageResult pagingQuery(QueryPageBean queryPageBean) {
        // 2. 获取MyBatis会话对象
        SqlSession sqlSession = SqlSessionUtil.getSession();

        // 3. 获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4. 使用JavaBean对象, 获取起始索引, 每页条数
        // 4. 使用接口代理对象, 调用接口中的分页查询方法
        List<User> list = mapper.pagingQuery(queryPageBean.getOffset(), queryPageBean.getPageSize());

        // 5. 使用接口代理对象, 查询总记录数方法
        Long total = mapper.count();

        // 6. 创建存储查询结果的实体类PageResult对象
        PageResult pageResult = new PageResult(total, list);
        SqlSessionUtil.commitAndClose(sqlSession);
        // 8. 将分页查询结果实体类对象返回给web层调用
        return pageResult;
    }
}
