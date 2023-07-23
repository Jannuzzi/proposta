package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.domain.proposta.SaidaProposta;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;

@FunctionalInterface
public interface SagaUseCase<T extends SaidaProposta> {
    T executar(SagaValidadores sagaValidadores);
}
