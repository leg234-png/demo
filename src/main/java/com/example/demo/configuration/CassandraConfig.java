package com.example.demo.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "taxibid";
    }

    @Override
    protected String getContactPoints() {
        return System.getenv("SPRING_DATA_CASSANDRA_CONTACT_POINTS");
    }

    @Override
    protected int getPort() {
        return Integer.parseInt(System.getenv("SPRING_DATA_CASSANDRA_PORT"));
    }

    @Override
    protected String getLocalDataCenter() {
        return "datacenter1";
    }

    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints(getContactPoints());
        session.setPort(getPort());
        session.setLocalDatacenter(getLocalDataCenter());
        session.setKeyspaceName(getKeyspaceName());
        return session;
    }
}

