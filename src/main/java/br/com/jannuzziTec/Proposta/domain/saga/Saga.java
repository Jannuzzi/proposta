package br.com.jannuzziTec.Proposta.domain.saga;

import br.com.jannuzziTec.Proposta.domain.usacases.SagaDefaultImpl;
import lombok.Getter;

@Getter
public enum Saga {

    DEFAULT {
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return new SagaDefaultImpl(sagaValidadores).enquadrar();
        }

        public GrupoSaga grupo() {
            return GrupoSaga.DEFAULT;
        }
    },

    DEFAULT_FORMALIZACAO_REMOTA {
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return false; //new SagaDefaultFormalizacaoRemotaImpl(sagaValidadores).enquadrar();
        }

        public GrupoSaga grupo() {
            return GrupoSaga.DEFAULT;
        }
    },
    ICDC {
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return false; //new SagaICDCImpl(sagaValidadores).enquadrar();
        }

        public GrupoSaga grupo() {
            return GrupoSaga.ICDC;
        }
    },
    PARCELA_UNICA {
        public boolean enquadrar(SagaValidadores sagaValidadores) {
            return false; //new SagaParcelaUnicaImpl(sagaValidadores).enquadrar();
        }

        public GrupoSaga grupo() {
            return GrupoSaga.PARCELA_UNICA;
        }
    };

    public abstract boolean enquadrar(SagaValidadores sagaValidadores);

    public abstract GrupoSaga grupo();

}
