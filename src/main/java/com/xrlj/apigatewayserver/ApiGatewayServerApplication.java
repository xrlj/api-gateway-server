package com.xrlj.apigatewayserver;

import com.xrlj.framework.base.BaseSpringbootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.xrlj.apigatewayserver", "com.xrlj.framework"})
@EnableDiscoveryClient
@EnableEurekaClient //可注册到服务中心
@EnableFeignClients
@RefreshScope
@EnableConfigurationProperties
@EnableRedisHttpSession
public class ApiGatewayServerApplication extends BaseSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServerApplication.class, args);
        log.info(">>>>>服务{}启动成功：{}", ApiGatewayServerApplication.class.getSimpleName(), args);
    }

    @RestController
    @RequestMapping("/api")
    class ApiController {

        @Autowired
        private MessageSource messageSource;
    }
}
