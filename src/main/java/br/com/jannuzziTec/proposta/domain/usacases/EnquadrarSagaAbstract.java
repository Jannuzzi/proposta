package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;

import java.util.EnumMap;
import java.util.function.Supplier;


public abstract class EnquadrarSagaAbstract implements EnquadrarSagaUseCase {

    protected EnumMap<Action, Supplier<Boolean>> enumMap = new EnumMap<>(Action.class);
    protected SagaValidadores sagaValidadores;

    public EnquadrarSagaAbstract(SagaValidadores sagaValidadores){
        this.sagaValidadores = sagaValidadores;
        preencherActions();
    }

    @Override
    public boolean enquadrar() {
        final Supplier<Boolean> valorRegra = enumMap.get(sagaValidadores.getAction());
        return valorRegra != null && valorRegra.get();
    }

    public abstract void preencherActions();

}
