package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;

public class EnquadrarSagaDefaultImpl extends EnquadrarSagaAbstract {

    public EnquadrarSagaDefaultImpl(SagaValidadores sagaValidadores) {
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
