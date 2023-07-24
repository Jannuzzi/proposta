package br.com.jannuzziTec.proposta.domain.usacases.impl;

import br.com.jannuzziTec.proposta.dataprovider.http.ConsultarParametrosDefaultAdapter;
import br.com.jannuzziTec.proposta.domain.usacases.DadosComplementaresUseCase;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.GerarPropostaInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DadosComplementaresDefaultImpl implements DadosComplementaresUseCase {

    private final ConsultarParametrosDefaultAdapter consultarParametros;

    @Override
    public void consultarDadosComplementares(GerarPropostaInput gerarPropostaInput) {

    }
}
