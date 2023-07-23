package br.com.jannuzziTec.proposta.domain.saga;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import lombok.*;

@AllArgsConstructor(staticName = "of")
@Getter
@ToString
@Builder
@Setter
public class SagaValidadores {
    private Saga saga;
    private String canal;
    private String tipoNegociacao;
    private Action action;
}
