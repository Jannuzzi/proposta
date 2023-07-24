package br.com.jannuzziTec.proposta.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSns;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class RedisConfiguration {
}
