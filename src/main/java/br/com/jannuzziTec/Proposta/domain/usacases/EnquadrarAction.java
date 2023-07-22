package br.com.jannuzziTec.Proposta.domain.usacases;

import br.com.jannuzziTec.Proposta.domain.saga.SagaValidadores;

public interface EnquadrarAction {
    boolean enquadrar(SagaValidadores sagaValidadores);
}
