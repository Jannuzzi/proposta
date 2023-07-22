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
        enumMap.put(Action.GERAR, new EnquadrarGerar());
        enumMap.put(Action.CONFIRMAR, new EnquadrarConfirmar());
        enumMap.put(Action.CONSULTAR, new EnquadrarConsultar());
    }

    static class EnquadrarGerar implements EnquadrarAction {
        @Override
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return sagaValidadores.getSaga() == Saga.DEFAULT;
        }
    }

    static class EnquadrarConfirmar implements EnquadrarAction {
        @Override
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return sagaValidadores.getSaga() == Saga.DEFAULT;
        }
    }

    static class EnquadrarConsultar implements EnquadrarAction {
        @Override
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return sagaValidadores.getSaga() == Saga.DEFAULT;
        }
    }
}
