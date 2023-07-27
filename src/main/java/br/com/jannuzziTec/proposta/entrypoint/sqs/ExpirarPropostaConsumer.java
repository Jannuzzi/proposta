package br.com.jannuzziTec.proposta.entrypoint.sqs;

import br.com.jannuzziTec.proposta.domain.saga.mapper.PropostaInputToSagaValidadoresMapper;
import br.com.jannuzziTec.proposta.domain.usacases.ExpirarPropostaUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class ExpirarPropostaConsumer {

    private final ExpirarPropostaUseCase expirarPropostaUseCase;
    private final PropostaInputToSagaValidadoresMapper sagaValidadoresMapper;

    public void propostasExpiradas(@Headers Map<String, Object> headers,
                                   String idProposta,
                                   Acknowledgment ackt){
        try {
            expirarPropostaUseCase.expirarProposta(idProposta);
            ackt.acknowledge();
        } catch (Exception e) {

        }
    }
}
