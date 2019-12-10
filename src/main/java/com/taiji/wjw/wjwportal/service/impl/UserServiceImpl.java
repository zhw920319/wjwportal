package com.taiji.wjw.wjwportal.service.impl;

import com.taiji.wjw.wjwportal.entity.User;
import com.taiji.wjw.wjwportal.mapper.UserMapper;
import com.taiji.wjw.wjwportal.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhw
 * @since 2019-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private  UserMapper userMapper;
    @Override
    public List<User> queryListByPageNo(int pageNo, int pageSize) {
        List<User> users = userMapper.queryListByPageNo(pageNo, pageSize);
        return users;
    }
}
