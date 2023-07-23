package br.com.jannuzziTec.proposta.domain.message.dto;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@ToString
public class MessageDTO {
    private Action action;
    private String idProposta;
    private Saga saga;
}
