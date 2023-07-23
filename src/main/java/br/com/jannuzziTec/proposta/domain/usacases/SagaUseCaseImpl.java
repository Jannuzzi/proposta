package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.domain.message.MessageResponse;
import br.com.jannuzziTec.proposta.domain.message.dto.MessageDTO;
import br.com.jannuzziTec.proposta.domain.message.mapper.MessageDTOMapper;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;
import br.com.jannuzziTec.proposta.domain.saga.dto.SagaPropostaDTO;
import br.com.jannuzziTec.proposta.domain.saga.mapper.SagaPropostaMapper;
import br.com.jannuzziTec.proposta.ports.SendMessageRequestPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SagaUseCaseImpl implements SagaUseCase<Proposta>{
    private final MotorSagaUseCase motorSagaUseCase;
    private final SendMessageRequestPort sendMessageRequestPort;

    private final MessageDTOMapper messageDTOMapper;
    private final SagaPropostaMapper sagaPropostaMapper;
    @Override
    public Proposta executar(SagaValidadores sagaValidadores) {

        //fazer as Consultas de dados complementares

        Saga saga = motorSagaUseCase.enquadrarSaga(sagaValidadores);

        String idProposta = Proposta.gerarIdProposta();

        SagaPropostaDTO sagaPropostaDTO = Optional.of(sagaPropostaMapper.apply(saga, idProposta)).get();

        MessageDTO messageDTO = Optional.of(sagaValidadores)
                .map((sagavalidadores1) -> messageDTOMapper.apply(sagaValidadores, sagaPropostaDTO)).get();

        MessageResponse messageResponse = sendMessageRequestPort.sendMessage(messageDTO);

        return null;

    }
}
