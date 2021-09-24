package com.github.feiyu.mybatis.log.config;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.Properties;
@Intercepts({
        @Signature(
                type= ResultSetHandler.class,
                method = "handleResultSets",
                args = {Statement.class}

        )
})

public class ResultInter  implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        System.out.println(args[0]);
        System.out.println("结果拦截器执行了2");
        Object result = invocation.proceed();
        System.out.println(result);
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
