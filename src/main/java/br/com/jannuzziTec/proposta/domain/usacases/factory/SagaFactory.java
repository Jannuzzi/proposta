package br.com.jannuzziTec.proposta.domain.usacases.factory;

import br.com.jannuzziTec.proposta.dataprovider.http.ConsultarParametrosDefaultAdapter;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.usacases.DadosComplementaresUseCase;
import br.com.jannuzziTec.proposta.domain.usacases.impl.DadosComplementaresDefaultImpl;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class SagaFactory {

    public static Map<Saga, DadosComplementaresUseCase> mapaSaga = new EnumMap<>(Saga.class);

    public SagaFactory(ConsultarParametrosDefaultAdapter consultarParametros){
        mapaSaga.put(Saga.DEFAULT, new DadosComplementaresDefaultImpl(consultarParametros));
    }
}
