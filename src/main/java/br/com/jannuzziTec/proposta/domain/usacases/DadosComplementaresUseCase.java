package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.entrypoint.controller.mapper.GerarPropostaRequestToInput;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.GerarPropostaInput;

public interface DadosComplementaresUseCase {

    void consultarDadosComplementares(GerarPropostaInput gerarPropostaInput);
}
