package com.taiji.wjw.wjwportal.config.ws;

import com.taiji.wjw.wjwportal.ws.UserWsService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * 配置服务访问路径并发布服务
 */
@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private UserWsService userWsService;

    /**
     *  发布服务
     *  指定访问url
     * 站点服务
     * @return
     */
    @Bean
    public Endpoint userWsServiceEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus,userWsService);
        endpoint.publish("/aaaa");
        return endpoint;
    }
//    发布多个服务
//    @Bean
//    public Endpoint aaaWsServiceEndpoint(){
//        EndpointImpl endpoint = new EndpointImpl(bus,userWsService);
//        endpoint.publish("/bbbbb");
//        return endpoint;
//    }

    /**
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/user?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/soap/user?wsdl
     * cxf和springboot版本不兼容，springboot版本太高
     * 修改方法：
     * 方法一：降低Spring boot版本，至2.0以下
     * 方法二：删除上面报错代码处，并在application.yml中添加如下配置：
     */
    /*@Bean
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/soap/*");
    }*/
}
