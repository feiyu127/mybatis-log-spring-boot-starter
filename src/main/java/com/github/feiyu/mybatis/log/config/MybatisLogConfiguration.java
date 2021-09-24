package com.github.feiyu.mybatis.log.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisLogConfiguration {
    @Bean
    @ConditionalOnProperty(value = "feiyu127.mybatis.log.exec", havingValue = "true")
    public ExecSqlInter execSqlInter(){
        return new ExecSqlInter();
    }

    @Bean
    @ConditionalOnProperty(value = "feiyu127.mybatis.log.result", havingValue = "true")
    public ResultInter resultSqlInter(){
        return new ResultInter();
    }
}
