package com.tech.jpa.persistance.config;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by x074823 on 8/15/2016.
 */
@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.tech.jpa.persistance.repository")
public class JpaConfig {

    @Autowired
    private Environment env;

    DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setURL(env.getProperty("spring.datasource.url"));
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        dataSource.setConnectionCachingEnabled(true);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") final DataSource datasource) throws SQLException {
        HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
        hibernateJpa.setDatabasePlatform(env.getProperty("spring.jpa.database-platform"));
        hibernateJpa.setGenerateDdl(true);
        hibernateJpa.setShowSql(env.getProperty("hibernate.show_sql", Boolean.class));
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(datasource);
        emf.setPackagesToScan("com.tech.jpa.persistance.entity");
        emf.setJpaVendorAdapter(hibernateJpa);
        return emf;
    }

}
