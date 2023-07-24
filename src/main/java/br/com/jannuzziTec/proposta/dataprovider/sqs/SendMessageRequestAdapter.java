package br.com.jannuzziTec.proposta.dataprovider.sqs;

import br.com.jannuzziTec.proposta.domain.message.MessageResponse;
import br.com.jannuzziTec.proposta.domain.message.dto.MessageDTO;
import br.com.jannuzziTec.proposta.ports.SendMessageRequestPort;
import com.amazonaws.services.sqs.AmazonSQSRequester;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@RequiredArgsConstructor
public class SendMessageRequestAdapter implements SendMessageRequestPort {

    private final AmazonSQSRequester amazonSQSRequester;

    @Value("${cloud.aws.requester-queue}")
    private String queueURL;

    @Override
    public MessageResponse sendMessage(MessageDTO message) {
        try {
            SendMessageRequest sendRequest =
                    SendMessageRequest.builder()
                            .queueUrl(queueURL)
                            .messageBody(message.toString())
                            .build();

            Message response = amazonSQSRequester.sendMessageAndGetResponse(sendRequest, 30, TimeUnit.SECONDS);
            String result = response.body();

            return null;

        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

    }
}
