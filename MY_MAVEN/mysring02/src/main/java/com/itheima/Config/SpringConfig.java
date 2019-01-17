package com.itheima.Config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.itheima")
public class SpringConfig {
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setUser("root");
            ds.setPassword("ROOT");
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql:///travel");
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Bean(name = "query")
    public QueryRunner caeat(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
}
