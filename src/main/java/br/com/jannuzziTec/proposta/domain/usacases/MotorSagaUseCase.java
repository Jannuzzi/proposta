package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;

public interface MotorSagaUseCase {

    Saga enquadrarSaga(final SagaValidadores saga);
}
