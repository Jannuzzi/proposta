package br.com.jannuzziTec.proposta.domain.proposta;

import br.com.jannuzziTec.proposta.domain.saga.Saga;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Proposta implements SaidaProposta{//TODO avaliar outra formar de fazer isso
    private String idProposta;
    private String canal;
    private Saga saga;
    private TipoNegociacacao tipoNegociacacao;

    public static String gerarIdProposta(){
        return "1234";
    }
}
