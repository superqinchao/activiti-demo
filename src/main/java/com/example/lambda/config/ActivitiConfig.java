package com.example.lambda.config;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ActivitiConfig
 * @Description TODO
 * @Author Chao.Qin
 * @Datw 2019/8/28 15:50
 */
@Configuration
public class ActivitiConfig extends AbstractProcessEngineAutoConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource activitiDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(PlatformTransactionManager transactionManager, SpringAsyncExecutor executor) throws IOException {
        return baseSpringProcessEngineConfiguration(activitiDataSource(), transactionManager, executor);
    }

    //    @Autowired
//    private ProcessEngine processEngine;


//    @Bean
//    public void fingVersionProcesses() {
//        List<ProcessDefinition> processDefinitionList = processEngine.getRepositoryService()
//                .createProcessDefinitionQuery()
//                .orderByProcessDefinitionVersion()
//                .asc()
//                .list();
//    }
}
