package com.company.project.config;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.company.project")
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableScheduling
//@PropertySource("classpath:application.properties")
public class Application
{

	public static void main(final String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public DataSource dataSource() {
//		EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
//		factory.setDatabaseName("spring-social-showcase");
//		factory.setDatabaseType(EmbeddedDatabaseType.H2);
//		return factory.getDatabase();
		
		DriverManagerDataSource mysqldataSource = new DriverManagerDataSource();
	    mysqldataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    mysqldataSource.setUrl("jdbc:mysql://localhost:3306/dbName?useConfigs=maxPerformance&characterEncoding=utf8");
	    mysqldataSource.setUsername("root");
	    mysqldataSource.setPassword("root");
	    return mysqldataSource; 
		
	}

	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public PlatformTransactionManager transactionManager()
	{
		return new DataSourceTransactionManager(dataSource());
	}
	
}
