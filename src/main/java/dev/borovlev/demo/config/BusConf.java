package dev.borovlev.demo.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;

@EnableBinding(Source.class)
@Configuration
public class BusConf {
}
