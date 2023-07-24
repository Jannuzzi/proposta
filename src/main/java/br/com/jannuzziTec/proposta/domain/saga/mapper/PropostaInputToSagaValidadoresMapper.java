package br.com.jannuzziTec.proposta.domain.saga.mapper;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.GerarPropostaInput;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
public class PropostaInputToSagaValidadoresMapper
        implements BiFunction<GerarPropostaInput, Action, SagaValidadores> {

    @Override
    @NotNull
    public SagaValidadores apply(GerarPropostaInput gerarPropostaInput, Action action) {
        return SagaValidadores.builder()
                .action(action)
                .canal(gerarPropostaInput.getCanal())
                .saga(gerarPropostaInput.getSaga())
                .tipoNegociacao(gerarPropostaInput.getIdProposta())
                .build();
    }
}
