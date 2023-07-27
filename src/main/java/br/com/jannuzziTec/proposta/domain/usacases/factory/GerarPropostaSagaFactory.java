package br.com.jannuzziTec.proposta.domain.usacases.factory;

import br.com.jannuzziTec.proposta.dataprovider.http.ConsultarParametrosDefaultDataProvider;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.usacases.DadosComplementaresSagaUseCase;
import br.com.jannuzziTec.proposta.domain.usacases.impl.DadosComplementaresSagaDefaultImpl;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class GerarPropostaSagaFactory {

    public static Map<Saga, DadosComplementaresSagaUseCase> mapaSaga = new EnumMap<>(Saga.class);

    public GerarPropostaSagaFactory(ConsultarParametrosDefaultDataProvider consultarParametros){
        mapaSaga.put(Saga.DEFAULT, new DadosComplementaresSagaDefaultImpl(consultarParametros));
    }
}
