package br.com.jannuzziTec.Proposta.domain.usacases;

import br.com.jannuzziTec.Proposta.domain.actions.Action;
import br.com.jannuzziTec.Proposta.domain.saga.SagaValidadores;

import java.util.EnumMap;


public abstract class SagaAbstract implements EnquadrarSaga {

    protected EnumMap<Action, EnquadrarAction> enumMap = new EnumMap<>(Action.class);
    protected SagaValidadores sagaValidadores;

    public SagaAbstract(SagaValidadores sagaValidadores){
        this.sagaValidadores = sagaValidadores;
        preencherActions();
    }

    @Override
    public boolean enquadrar() {
        return enumMap.get(sagaValidadores.getAction()).enquadrar(sagaValidadores);
    }

    public abstract void preencherActions();

}
