package hello.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;


@Configuration
@EnableMongoRepositories("hello.repository")
@PropertySource({ "classpath:mongo.properties" })
@ComponentScan(basePackages = "hello")
public class MongoDbConfig extends AbstractMongoConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(MongoDbConfig.class);


    @Autowired
    private Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getRequiredProperty("db.name");
    }

    @Override
    public Mongo mongo() {
        MongoClient client = null;
        try {
            client = new MongoClient(env.getRequiredProperty("db.IP"), Integer.valueOf(env.getRequiredProperty("db.port")));
        } catch (UnknownHostException e) {
            LOG.debug("unknown hostException");
        }
        return client;
    }

    @Override
    protected String getMappingBasePackage() {
        return "hello.model";
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}