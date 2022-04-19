package tr.com.erpsample.grocery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({ "tr.com.erpsample.grocery.repository" })
@EnableTransactionManagement
public class DatabaseConfiguration {}
