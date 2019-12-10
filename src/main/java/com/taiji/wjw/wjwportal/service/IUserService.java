package com.taiji.wjw.wjwportal.service;

import com.taiji.wjw.wjwportal.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhw
 * @since 2019-12-10
 */
public interface IUserService extends IService<User> {
    List<User> queryListByPageNo(int pageNo, int pageSize);
}
