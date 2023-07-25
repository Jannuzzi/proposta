package br.com.jannuzziTec.proposta.domain.message.mapper;

import br.com.jannuzziTec.proposta.domain.message.dto.MessageDTO;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;
import br.com.jannuzziTec.proposta.domain.saga.dto.SagaPropostaDTO;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
@Service
public class MessageDTOMapper implements BiFunction<SagaValidadores, Proposta, MessageDTO> {

    @Override
    public MessageDTO apply(SagaValidadores sagaValidadores, Proposta proposta) {
        return MessageDTO.builder()
                .action(sagaValidadores.getAction())
                .idProposta(proposta.getIdProposta())
                .saga(proposta.getSaga())
                .build();
    }
}
