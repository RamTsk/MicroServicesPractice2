package com.mphasis.storeapp.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {
    @Value("spring.datasource.driver.class")
    private static String driverClassName;
    @Value("${spring.datasource.url}")
    private static String url;
    @Value("${spring.datasource.username}")
    private static String username;
    @Value("${spring.datasource.password}")
    private static String password;
    @Bean(name="dataSource")
    public static DataSource dataSource(){
//        HikariDataSource ds = new HikariDataSource();
//        ds.setDataSourceClassName(driverClassName);
//        ds.setJdbcUrl();
//        ds.setUsername(username);
//        ds.setPassword(password);
//        return ds;

        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(100);
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE"); ;
        ds.setUsername("username");
        ds.setPassword("password");
        return ds;
    }
    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
    @Bean(name="jdbcTemplate")
    public static JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
//    @Bean(name="transactionTemplate")
//    public TransactionTemplate transactionTemplate(){
//        return new TransactionTemplate(transactionManager());
//    }
//    @Bean
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
//        return new NamedParameterJdbcTemplate(jdbcTemplate());
//    }
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
