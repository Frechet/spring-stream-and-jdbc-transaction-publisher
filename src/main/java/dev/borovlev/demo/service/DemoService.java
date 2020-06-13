package dev.borovlev.demo.service;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    private final Source bus;
    private final JdbcTemplate jdbcTemplate;

    public DemoService(Source bus, JdbcTemplate jdbcTemplate) {
        this.bus = bus;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void doSomethingTransactional() {
        bus.output().send(MessageBuilder.withPayload("Test").build());
        jdbcTemplate.execute("INSERT INTO person (firstname, lastname) VALUES ('first', 'last')");


        throw new RuntimeException("Test transaction messaging and jdbc");
    }
}
