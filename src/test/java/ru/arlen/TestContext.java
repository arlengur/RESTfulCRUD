package ru.arlen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.arlen.dao.AccountDAO;
import ru.arlen.dao.AccountDAOImpl;

import javax.sql.DataSource;

/**
 * @author satovritti
 */
@Configuration
public class TestContext {
    /**
     * Create H2DB data source.
     *
     * @return h2 database bean.
     */
    @Bean
    public DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("create-db.sql")
                .addScript("insert-data.sql")
                .build();
    }

    /**
     * Create jdbc template for H2DB.
     *
     * @return h2 database named parameter jdbc template.
     */
    @Bean
    public NamedParameterJdbcTemplate h2Template() {
        return new NamedParameterJdbcTemplate(h2DataSource());
    }

    @Bean
    public AccountDAO accountDAO() {
        return new AccountDAOImpl();
    }
}