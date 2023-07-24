package br.com.jannuzziTec.proposta.entrypoint.controller.mapper;

import br.com.jannuzziTec.proposta.entrypoint.controller.model.GerarPropostaInput;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.GerarPropostaRequest;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GerarPropostaRequestToInput implements Function<GerarPropostaRequest, GerarPropostaInput> {

    @Override
    @NonNull
    public GerarPropostaInput apply(GerarPropostaRequest gerarPropostaRequest) {
        return GerarPropostaInput.builder()
                .canal(gerarPropostaRequest.getCanal())
                .saga(gerarPropostaRequest.getSaga())
                .tipoNegociacacao(gerarPropostaRequest.getTipoNegociacacao())
                .build();
    }
}
