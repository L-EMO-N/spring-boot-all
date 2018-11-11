package com.lemon.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 *
 * @author LEMON
 */
@Configuration
@ComponentScan(basePackages = {"com.lemon"},
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
    }
)
@EnableTransactionManagement    //开启事物
public class RootConfig {


    /** 
     *数据源
     *@author LEMON
    */
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/zhiyinguan?userUnicode=true&characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setInitialSize(4);
        dataSource.setMinIdle(2);
        dataSource.setMaxActive(10);
        dataSource.setMaxWait(5000);
        dataSource.setRemoveAbandoned(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        dataSource.setPoolPreparedStatements(true);
        return dataSource;
    }


    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return  transactionManager;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.lemon.*.entity");
        return factoryBean;
    }


    /**
     *配置mapper接口扫描器     *@author LEMON
    */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.lemon.*.dao");
        return scannerConfigurer;

    }

}
