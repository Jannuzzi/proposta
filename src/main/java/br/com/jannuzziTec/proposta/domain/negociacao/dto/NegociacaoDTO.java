package br.com.jannuzziTec.proposta.domain.negociacao.dto;

import br.com.jannuzziTec.proposta.domain.proposta.TipoNegociacacao;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NegociacaoDTO {
    private String idProposta;
    private String canal;
    private Saga saga;
    private TipoNegociacacao tipoNegociacacao;
}
