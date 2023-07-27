package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.domain.proposta.Proposta;

@FunctionalInterface
public interface ExpirarPropostaSagaUseCase {
    void executar(Proposta proposta);
}
