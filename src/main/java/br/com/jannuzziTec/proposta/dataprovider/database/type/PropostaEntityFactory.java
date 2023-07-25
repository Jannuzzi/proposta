package br.com.jannuzziTec.proposta.dataprovider.database.type;

import br.com.jannuzziTec.proposta.dataprovider.database.mapper.PropostaToPropostaEntityTypeMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropostaEntityFactory {

    public static List<DynamoDbEntityType> entityTypeMap = new ArrayList<>();

    public PropostaEntityFactory(PropostaToPropostaEntityTypeMapper propostaToPropostaEntityTypeMapper){
        entityTypeMap.add(new PropostaEntityType(propostaToPropostaEntityTypeMapper));
        entityTypeMap.add(new PropostaEntityType(propostaToPropostaEntityTypeMapper));//TODO adicionar novas impls
    }
}
