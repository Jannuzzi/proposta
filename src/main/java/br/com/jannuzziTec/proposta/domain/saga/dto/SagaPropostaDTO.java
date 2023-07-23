package br.com.jannuzziTec.proposta.domain.saga.dto;

import br.com.jannuzziTec.proposta.domain.saga.Saga;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SagaPropostaDTO {
    private Saga saga;
    private String idProposta;
}
