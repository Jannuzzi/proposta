package br.com.jannuzziTec.Proposta.domain.saga;

import br.com.jannuzziTec.Proposta.domain.actions.Action;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(staticName = "of")
@Getter
public class SagaValidadores {
    private Saga Saga;
    private String canal;
    private String TipoNegociacao;
    private Action action;
}
