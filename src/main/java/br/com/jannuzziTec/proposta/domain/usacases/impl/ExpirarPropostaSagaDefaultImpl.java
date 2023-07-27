package br.com.jannuzziTec.proposta.domain.usacases.impl;

import br.com.jannuzziTec.proposta.dataprovider.database.PropostaDynamoDBDataProvider;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.domain.usacases.ExpirarPropostaSagaUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpirarPropostaSagaDefaultImpl implements ExpirarPropostaSagaUseCase {

    private final PropostaDynamoDBDataProvider dataProvider;

    @Override
    public void executar(Proposta proposta) {

    }
}
