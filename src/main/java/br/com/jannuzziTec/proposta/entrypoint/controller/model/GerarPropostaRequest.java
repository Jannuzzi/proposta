package br.com.jannuzziTec.proposta.entrypoint.controller.model;

import br.com.jannuzziTec.proposta.domain.proposta.TipoNegociacacao;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GerarPropostaRequest {
    private String idProposta;
    private String canal;
    private Saga saga;
    private TipoNegociacacao tipoNegociacacao;
}
