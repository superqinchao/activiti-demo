package com.example.lambda.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DaoConfiguration
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/9/17 14:50
 */
@Configuration
@MapperScan("com.example.lambda.generator.mapper")
public class DaoConfiguration {
}
