package br.com.jannuzziTec.Proposta.domain.saga;

import br.com.jannuzziTec.Proposta.domain.actions.Action;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@Getter
@ToString
public class SagaValidadores {
    private Saga Saga;
    private String canal;
    private String TipoNegociacao;
    private Action action;
}
