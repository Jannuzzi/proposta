package br.com.jannuzziTec.proposta.dataprovider;

import br.com.jannuzziTec.proposta.dataprovider.database.PropostaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PropostaDataProvider {
    private final PropostaRepository propostaRepository;
}
