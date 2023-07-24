package br.com.jannuzziTec.proposta.entrypoint.controller.model;

import br.com.jannuzziTec.proposta.domain.proposta.TipoNegociacacao;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GerarPropostaInput implements PropostaInput {
    private String idProposta;
    private String canal;
    private Saga saga;
    private TipoNegociacacao tipoNegociacacao;
}
