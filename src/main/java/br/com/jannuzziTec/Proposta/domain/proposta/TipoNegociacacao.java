package br.com.jannuzziTec.Proposta.domain.proposta;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoNegociacacao {

    CLEAN(76),
    PARCELA_UNICA(81),
    IR(12),
    DECIMO_TERCEIRO(13)
    ;

    private Integer tipo;
}
