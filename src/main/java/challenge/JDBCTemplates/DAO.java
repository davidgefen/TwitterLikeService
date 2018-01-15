package challenge.JDBCTemplates;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by davidbra on 6/30/17.
 */
@Configuration
@ComponentScan
@PropertySource("classpath:/application.properties")
@EnableAutoConfiguration
public abstract class DAO{

    protected NamedParameterJdbcTemplate jdbcTemplateObject;
    private DataSource ds;

    public DAO(){
        this.ds = dataSource();
        jdbcTemplateObject = new NamedParameterJdbcTemplate(ds);
    }

    @Value("${spring.datasource.url}")
    private String jdbcURl = "jdbc:h2:mem:challenge";

    @Value("${spring.datasource.username}")
    private String dbUsername = "user";

    @Value("${spring.datasource.password}")
    private String dbPassword = "1234";

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username(dbUsername)
                .password(dbPassword)
                .url(jdbcURl)
                .build();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(this.ds);

        return dataSourceTransactionManager;
    }

    //TODO connect DAO to application.properties
    //TODO create interfaces

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new NamedParameterJdbcTemplate(dataSource);
    }
}
