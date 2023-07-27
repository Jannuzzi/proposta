package br.com.jannuzziTec.proposta.dataprovider.database.type;

import br.com.jannuzziTec.proposta.dataprovider.database.entity.PropostaEntity;
import br.com.jannuzziTec.proposta.dataprovider.database.mapper.PropostaToPropostaEntityTypeMapper;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component//TODO acho que não precisa.
public class PropostaEntityType implements DynamoDbEntityType {

    private final PropostaToPropostaEntityTypeMapper propostaToPropostaEntityTypeMapper;
🤨
    public PropostaEntityType(PropostaToPropostaEntityTypeMapper propostaToPropostaEntityTypeMapper) {
        this.propostaToPropostaEntityTypeMapper = propostaToPropostaEntityTypeMapper;
    }

    @Override
    public List<PropostaEntity> criarEntity(Proposta proposta) {
        return List.of(propostaToPropostaEntityTypeMapper.apply(proposta, resgatarChaves()));
    }

    @Override
    public List<String> resgatarChaves() {
        return new LinkedList<>(List.of(ChavesDynamoDB.CHAVE_PARTICAO, ChavesDynamoDB.CHAVE_PARTICAO));
    }
}
