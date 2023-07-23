package br.com.jannuzziTec.Proposta.domain.saga;

import br.com.jannuzziTec.Proposta.domain.usacases.SagaDefaultImpl;

public enum Saga  {

    DEFAULT {
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return new SagaDefaultImpl(sagaValidadores).enquadrar();
        }
    },

    DEFAULT_FORMALIZACAO_REMOTA{
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return false; //new SagaDefaultImpl(sagaValidadores).enquadrar();
        }
    },
    ICDC{
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return false; //new SagaDefaultImpl(sagaValidadores).enquadrar();
        }
    },
    PARCELA_UNICA{
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return false; //new SagaDefaultImpl(sagaValidadores).enquadrar();
        }
    };

    public abstract boolean enquadrar(SagaValidadores sagaValidadores);

}
