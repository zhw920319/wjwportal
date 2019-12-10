package com.taiji.wjw.wjwportal.ws.impl;

import com.taiji.wjw.wjwportal.entity.User;
import com.taiji.wjw.wjwportal.mapper.UserMapper;
import com.taiji.wjw.wjwportal.ws.UserWsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(serviceName="UserService",//对外发布的服务名
        targetNamespace="http://service.ws.com/",//指定你想要的名称空间，通常使用使用包名反转
        endpointInterface= "com.taiji.wjw.wjwportal.ws.UserWsService")//服务接口全路径, 指定做SEI（Service EndPoint Interface）服务端点接口
@Component
//@BindingType(SOAPBinding.SOAP12HTTP_MTOM_BINDING) //@BindingType 注释指定在发布此类型的端点时要使用的绑定。将此注释应用于JavaBeans 端点或提供程序端点的服务器端点实现类
public class UserWsServiceImpl implements UserWsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User  getUser(String userId) {
        User user = userMapper.selectById(userId);
        return user;
    }
}
