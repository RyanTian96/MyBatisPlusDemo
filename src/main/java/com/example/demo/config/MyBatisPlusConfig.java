package com.example.demo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ryan Tian
 * @version 1.0
 * @date 2022/6/15 17:52
 * @description
 */
@Configuration
@MapperScan("com.example.demo.mapper")
public class MyBatisPlusConfig {

    /**
     *     配置分页插件
     */
    @Bean
    public MybatisPlusInterceptor MybatisPlusInterceptorP(){
        MybatisPlusInterceptor mpi = new MybatisPlusInterceptor();
        // 分页插件
        mpi.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 乐观锁
        mpi.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mpi;
    }

}
