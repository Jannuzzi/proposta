package br.com.jannuzziTec.proposta.web;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.negociacao.dto.NegociacaoDTO;
import br.com.jannuzziTec.proposta.domain.negociacao.Negociacao;
import br.com.jannuzziTec.proposta.domain.negociacao.mapper.NegociacaoDTOToNegociacaoMapper;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;
import br.com.jannuzziTec.proposta.domain.saga.mapper.NegociacaoToSagaValidadoresMapper;
import br.com.jannuzziTec.proposta.domain.usacases.SagaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController(value = "/propostas")
@RequiredArgsConstructor
public class GerarPropostaController {

    private static final Action GERAR = Action.GERAR;

    private final SagaUseCase<Proposta> sagaUseCase;
    private final NegociacaoDTOToNegociacaoMapper negociacaoMapper;
    private final NegociacaoToSagaValidadoresMapper sagaValidadoresMapper;


    @PostMapping
    public Proposta gerarProposta(@RequestBody NegociacaoDTO negociacaoDto){
        Negociacao negociacao = Optional.of(negociacaoDto).map(negociacaoMapper).get();

        SagaValidadores sagaValidadores =
                Optional.of(negociacao).map((negociacaoval) ->
                        sagaValidadoresMapper.apply(negociacaoval, GerarPropostaController.GERAR)
                ).get();

        return sagaUseCase.executar(sagaValidadores);
    }
}
