package br.com.jannuzziTec.proposta.configuration;

import com.amazonaws.services.sqs.AmazonSQSRequester;
import com.amazonaws.services.sqs.AmazonSQSRequesterClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSResponder;
import com.amazonaws.services.sqs.AmazonSQSResponderClientBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

@Configuration
@EnableSqs
public class SQSConfiguracao {

    @Bean
    public AmazonSQSRequester sqsRequester() {
        return AmazonSQSRequesterClientBuilder.standard().withAmazonSQS(getSqsClient()).build();
    }

    @Bean
    public AmazonSQSResponder sqsResponder() {
        return AmazonSQSResponderClientBuilder.standard().withAmazonSQS(getSqsClient()).build();
    }

    public SqsClient getSqsClient() {
        return SqsClient.builder().region(Region.SA_EAST_1).endpointOverride(URI.create("http://localhost:4566")).build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());
    }
}
