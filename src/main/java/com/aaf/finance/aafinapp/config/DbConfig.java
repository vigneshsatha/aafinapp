package com.aaf.finance.aafinapp.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("com.aaf.finance.aafinapp.model")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class DbConfig {
	Logger logger = LoggerFactory.getLogger(DbConfig.class);

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DataSource dataSource = DataSourceBuilder.create().username("root")
				.url("jdbc:mysql://localhost:3306/finance_database").driverClassName("com.mysql.jdbc.Driver").build();
		this.logger.info(dataSource.toString());

		return dataSource;
	}

	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("com.aaf.finance.aafinapp.model");
		return sessionBuilder.buildSessionFactory();
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		return initializer;
	}
}