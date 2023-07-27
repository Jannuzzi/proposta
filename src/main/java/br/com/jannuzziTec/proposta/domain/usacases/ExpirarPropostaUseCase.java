package br.com.jannuzziTec.proposta.domain.usacases;

@FunctionalInterface
public interface ExpirarPropostaUseCase {
    void expirarProposta(final String idProposta);
}
