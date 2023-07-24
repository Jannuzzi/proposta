package br.com.jannuzziTec.proposta.domain.usacases.impl;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.message.mapper.MessageDTOMapper;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;
import br.com.jannuzziTec.proposta.domain.saga.mapper.PropostaInputToSagaValidadoresMapper;
import br.com.jannuzziTec.proposta.domain.saga.mapper.SagaPropostaMapper;
import br.com.jannuzziTec.proposta.domain.usacases.MotorSagaUseCase;
import br.com.jannuzziTec.proposta.domain.usacases.GerarPropostaUseCase;
import br.com.jannuzziTec.proposta.domain.usacases.factory.SagaFactory;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.GerarPropostaInput;
import br.com.jannuzziTec.proposta.ports.SendMessageRequestPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GerarPropostaImpl implements GerarPropostaUseCase<GerarPropostaInput> {
    private static final Action GERAR = Action.GERAR;
    private final MotorSagaUseCase motorSagaUseCase;
    private final SagaFactory sagaFactory;
    private final SendMessageRequestPort sendMessageRequestPort;
    private final MessageDTOMapper messageDTOMapper;
    private final SagaPropostaMapper sagaPropostaMapper;

    private final PropostaInputToSagaValidadoresMapper sagaValidadoresMapper;
    @Override
    public Proposta executar(GerarPropostaInput gerarPropostaInput) {

        SagaValidadores sagaValidadores = sagaValidadoresMapper.apply(gerarPropostaInput, GERAR);
        Saga saga = motorSagaUseCase.enquadrarSaga(sagaValidadores);

        SagaFactory.mapaSaga.get(saga)
                .consultarDadosComplementares(gerarPropostaInput);

        //fazer as Consultas de dados complementares

        //String idProposta = Proposta.gerarIdProposta();

        //SagaPropostaDTO sagaPropostaDTO = Optional.of(sagaPropostaMapper.apply(saga, idProposta)).get();

       // MessageDTO messageDTO = Optional.of(sagaValidadores)
        //        .map((sagavalidadores1) -> messageDTOMapper.apply(sagaValidadores, sagaPropostaDTO)).get();

        //MessageResponse messageResponse = sendMessageRequestPort.sendMessage(messageDTO);

        return null;

    }
}
