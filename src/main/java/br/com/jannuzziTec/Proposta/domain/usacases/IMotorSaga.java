package br.com.jannuzziTec.Proposta.domain.usacases;

import br.com.jannuzziTec.Proposta.domain.saga.Saga;
import br.com.jannuzziTec.Proposta.domain.saga.SagaValidadores;

public interface IMotorSaga {

    Saga enquadrarSaga(final SagaValidadores saga);
}
