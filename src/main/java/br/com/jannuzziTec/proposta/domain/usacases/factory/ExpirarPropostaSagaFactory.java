package br.com.jannuzziTec.proposta.domain.usacases.factory;

import br.com.jannuzziTec.proposta.dataprovider.database.PropostaDynamoDBDataProvider;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.usacases.ExpirarPropostaSagaUseCase;
import br.com.jannuzziTec.proposta.domain.usacases.impl.ExpirarPropostaSagaDefaultImpl;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.Map;

@Service
public class ExpirarPropostaSagaFactory {

    public static Map<Saga, ExpirarPropostaSagaUseCase> mapaSaga = new EnumMap<>(Saga.class);

    public ExpirarPropostaSagaFactory(PropostaDynamoDBDataProvider dataProvider){
        mapaSaga.put(Saga.DEFAULT, new ExpirarPropostaSagaDefaultImpl(dataProvider));
    }
}
