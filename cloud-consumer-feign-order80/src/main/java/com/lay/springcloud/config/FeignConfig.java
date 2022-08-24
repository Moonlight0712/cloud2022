package com.lay.springcloud.config;

/**
 * @author Dragon code!
 * @create 2022-07-14 2:24
 */
import feign.Logger;	//不要导错包
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        //打印最详细的日志
        return Logger.Level.FULL;
    }

}
