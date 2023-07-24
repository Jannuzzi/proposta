package br.com.jannuzziTec.proposta.entrypoint.controller;

import br.com.jannuzziTec.proposta.entrypoint.controller.mapper.GerarPropostaRequestToInput;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.domain.usacases.GerarPropostaUseCase;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.GerarPropostaInput;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.GerarPropostaRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/propostas")
@RequiredArgsConstructor
public class GerarPropostaController {

    private final GerarPropostaUseCase<GerarPropostaInput> gerarPropostaUseCase;
    private final GerarPropostaRequestToInput mapper;

    @PostMapping
    public Proposta gerarProposta(@Valid @RequestBody GerarPropostaRequest gerarPropostaRequest){
        GerarPropostaInput request =  mapper.apply(gerarPropostaRequest);
        return gerarPropostaUseCase.executar(request);
    }
}
