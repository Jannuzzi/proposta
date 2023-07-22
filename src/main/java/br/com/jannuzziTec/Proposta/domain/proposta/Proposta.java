package br.com.jannuzziTec.Proposta.domain.proposta;

import br.com.jannuzziTec.Proposta.domain.saga.Saga;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Proposta {
    private String idProposta;
    private String canal;
    private Saga saga;
    private TipoNegociacacao tipoNegociacacao;
}
