package org.kt.temp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DefaultContextConfig {
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new HikariDataSource();
	}

	@Primary
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource ds) {
		DataSourceTransactionManager txm = new DataSourceTransactionManager(ds);
		return txm;
	}

	@Primary
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource ds) {
		return new JdbcTemplate(ds);
	}

	@Primary
	@Bean
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("dataSource") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
}
