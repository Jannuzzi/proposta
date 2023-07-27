package br.com.jannuzziTec.proposta.domain.usacases.impl;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;
import br.com.jannuzziTec.proposta.domain.saga.mapper.PropostaToSagaValidadoresMapper;
import br.com.jannuzziTec.proposta.domain.usacases.ExpirarPropostaUseCase;
import br.com.jannuzziTec.proposta.domain.usacases.MotorSagaUseCase;
import br.com.jannuzziTec.proposta.domain.usacases.factory.ExpirarPropostaSagaFactory;
import br.com.jannuzziTec.proposta.ports.PropostaDynamoDbPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpirarPropostaImpl implements ExpirarPropostaUseCase {

    private static final Action EXPIRAR = Action.EXPIRAR;
    private final MotorSagaUseCase motorSaga;
    private final PropostaDynamoDbPort propostaDynamoDbPort;
    private final PropostaToSagaValidadoresMapper sagaValidadoresMapper;
    @Override
    public void expirarProposta(String idProposta) {
        final Proposta proposta = propostaDynamoDbPort.consultar(idProposta);

        SagaValidadores sagaValidadores = sagaValidadoresMapper.apply(proposta, EXPIRAR);
        Saga saga = motorSaga.enquadrarSaga(sagaValidadores);

        ExpirarPropostaSagaFactory.mapaSaga.get(saga)
                .executar(proposta);
    }
}
