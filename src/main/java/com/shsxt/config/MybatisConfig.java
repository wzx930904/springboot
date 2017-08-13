package com.shsxt.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/1.
 */
@Configuration
@MapperScan("com.shsxt.dao")
public class MybatisConfig implements TransactionManagementConfigurer{

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactoryBean init() throws IOException {

        //new对象
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //set mybatis-config.xml文件
        Resource resource = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        //set mapper文件位置
        Resource[] mapperResources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
        sqlSessionFactoryBean.setMapperLocations(mapperResources);
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate initTemplate(SqlSessionFactory factory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(factory);
        return sqlSessionTemplate;
    }

    /**
     * 事务管理
     * @return
     */
    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
