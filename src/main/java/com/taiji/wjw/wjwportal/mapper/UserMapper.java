package com.taiji.wjw.wjwportal.mapper;

import com.taiji.wjw.wjwportal.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhw
 * @since 2019-12-10
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> queryListByPageNo(int pageNo, int pageSize);
}
