package br.com.jannuzziTec.proposta.domain.negociacao.mapper;

import br.com.jannuzziTec.proposta.domain.negociacao.dto.NegociacaoDTO;
import br.com.jannuzziTec.proposta.domain.negociacao.Negociacao;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class NegociacaoDTOToNegociacaoMapper implements Function<NegociacaoDTO, Negociacao> {

    @Override
    public Negociacao apply(NegociacaoDTO negociacaoDTO) {
        return Negociacao.builder()
                .canal(negociacaoDTO.getCanal())
                .saga(negociacaoDTO.getSaga())
                .tipoNegociacacao(negociacaoDTO.getTipoNegociacacao())
                .build();
    }
}
