package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.PropostaInput;

@FunctionalInterface
public interface GerarPropostaUseCase<R extends PropostaInput> {
    //TODO se criar um usecase para cada controller isso é desnecessario, trabalha com o objeto diretamente
    Proposta executar(R input);
}
