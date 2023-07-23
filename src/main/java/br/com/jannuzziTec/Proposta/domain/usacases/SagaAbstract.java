package br.com.jannuzziTec.Proposta.domain.usacases;

import br.com.jannuzziTec.Proposta.domain.actions.Action;
import br.com.jannuzziTec.Proposta.domain.saga.SagaValidadores;

import java.util.EnumMap;
import java.util.function.Supplier;


public abstract class SagaAbstract implements EnquadrarSaga {

    protected EnumMap<Action, Supplier<Boolean>> enumMap = new EnumMap<>(Action.class);
    protected SagaValidadores sagaValidadores;

    public SagaAbstract(SagaValidadores sagaValidadores){
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
