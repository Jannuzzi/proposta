package br.com.jannuzziTec.proposta.domain.proposta;

import br.com.jannuzziTec.proposta.domain.saga.Saga;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Proposta implements SaidaProposta{//TODO avaliar outra formar de fazer isso
    private String idProposta;
    private String canal;
    private Saga saga;
    private TipoNegociacacao tipoNegociacacao;

    public static String gerarIdProposta(){
        return "1234";
    }
}
