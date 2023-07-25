package br.com.jannuzziTec.proposta.dataprovider.database.mapper;

import br.com.jannuzziTec.proposta.dataprovider.database.entity.PropostaEntity;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiFunction;

@Service
public class PropostaToPropostaEntityTypeMapper implements BiFunction<Proposta, List<String>, PropostaEntity> {
    @Override
    public PropostaEntity apply(Proposta proposta, List<String> keys) {
        return PropostaEntity
                .builder()
                .chaveParticao(keys.get(0) + proposta.getIdProposta())
                .chaveFiltragem(keys.get(1) + proposta.getIdProposta())
                .saga(proposta.getSaga().name())
                .build();
    }
}
