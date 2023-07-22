package br.com.jannuzziTec.Proposta.domain.usacases;

import br.com.jannuzziTec.Proposta.domain.saga.SagaValidadores;

@FunctionalInterface
public interface EnquadrarSaga {
    boolean enquadrar();
}
