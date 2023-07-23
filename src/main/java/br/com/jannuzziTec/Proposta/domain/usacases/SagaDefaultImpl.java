package br.com.jannuzziTec.Proposta.domain.usacases;

import br.com.jannuzziTec.Proposta.domain.actions.Action;
import br.com.jannuzziTec.Proposta.domain.saga.Saga;
import br.com.jannuzziTec.Proposta.domain.saga.SagaValidadores;

public class SagaDefaultImpl extends SagaAbstract {

    public SagaDefaultImpl(SagaValidadores sagaValidadores) {
        super(sagaValidadores);
    }

    @Override
    public void preencherActions() {
        enumMap.put(Action.GERAR, () -> sagaValidadores.getSaga() == Saga.DEFAULT);
        enumMap.put(Action.CONFIRMAR, () -> sagaValidadores.getSaga() == Saga.DEFAULT);
        enumMap.put(Action.CONSULTAR, () -> sagaValidadores.getSaga() == Saga.DEFAULT);
        enumMap.put(Action.EXPIRAR, () -> sagaValidadores.getSaga() == Saga.DEFAULT);
        enumMap.put(Action.EFETIVAR, () -> sagaValidadores.getSaga() == Saga.DEFAULT);
    }
}
