package br.com.jannuzziTec.proposta.domain.saga.mapper;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.negociacao.Negociacao;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
public class NegociacaoToSagaValidadoresMapper implements BiFunction<Negociacao, Action, SagaValidadores> {

    @Override
    public SagaValidadores apply(Negociacao negociacao, Action action) {
        return SagaValidadores.builder()
                .action(action)
                .canal(negociacao.getCanal())
                .saga(negociacao.getSaga())
                .tipoNegociacao(negociacao.getIdProposta())
                .build();
    }
}
