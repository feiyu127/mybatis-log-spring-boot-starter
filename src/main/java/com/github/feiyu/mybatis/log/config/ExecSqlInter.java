package com.github.feiyu.mybatis.log.config;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

@Intercepts(
//        @Signature(
//                type= Executor.class,
//                method = "query",
//                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
//        ),
//        @Signature(
//                type=ParameterHandler.class,
//                method = "setParameters",
//                args = {PreparedStatement.class}
//        )
        {
                @Signature(type = StatementHandler.class,
                        method = "query",
                        args = {Statement.class, ResultHandler.class}),
                @Signature(
                        type = StatementHandler.class,
                        method = "update",
                        args = {Statement.class})
        }
)
public class ExecSqlInter implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        System.out.println(args[0]);
        System.out.println("参数拦截器执行了");
        Object result = invocation.proceed();

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
