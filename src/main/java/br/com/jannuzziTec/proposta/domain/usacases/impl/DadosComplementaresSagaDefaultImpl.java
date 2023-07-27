package br.com.jannuzziTec.proposta.domain.usacases.impl;

import br.com.jannuzziTec.proposta.domain.usacases.DadosComplementaresSagaUseCase;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.GerarPropostaInput;
import br.com.jannuzziTec.proposta.ports.ConsultarParametrosPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DadosComplementaresSagaDefaultImpl implements DadosComplementaresSagaUseCase {

    private final ConsultarParametrosPort consultarParametros;

    @Override
    public void consultarDadosComplementares(GerarPropostaInput gerarPropostaInput) {

    }
}
