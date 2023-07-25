package br.com.jannuzziTec.proposta.dataprovider.database.type;

import br.com.jannuzziTec.proposta.dataprovider.database.entity.PropostaEntity;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;

import java.util.List;

public interface DynamoDbEntityType {

    List<PropostaEntity> criarEntity(Proposta proposta);

    List<String> resgatarChaves();
}
