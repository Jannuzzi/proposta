package br.com.jannuzziTec.proposta.domain.saga.mapper;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
public class PropostaToSagaValidadoresMapper implements BiFunction<Proposta, Action, SagaValidadores> {
    @Override
    public SagaValidadores apply(Proposta proposta, Action action) {
        return SagaValidadores.builder()
                .action(action)
                .canal(proposta.getCanal())
                .saga(proposta.getSaga())
                .tipoNegociacao(proposta.getTipoNegociacacao().name())
                .build();
    }
}
