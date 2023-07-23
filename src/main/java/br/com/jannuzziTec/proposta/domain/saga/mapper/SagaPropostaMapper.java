package br.com.jannuzziTec.proposta.domain.saga.mapper;

import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.saga.dto.SagaPropostaDTO;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
public class SagaPropostaMapper implements BiFunction<Saga, String, SagaPropostaDTO> {
    @Override
    public SagaPropostaDTO apply(Saga saga, String idProposta) {
        return SagaPropostaDTO.builder()
                .saga(saga)
                .idProposta(idProposta)
                .build();
    }
}
