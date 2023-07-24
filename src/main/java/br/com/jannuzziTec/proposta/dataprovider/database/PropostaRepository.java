package br.com.jannuzziTec.proposta.dataprovider.database;

import br.com.jannuzziTec.proposta.dataprovider.database.entity.PropostaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;

@Component
@Slf4j
public class PropostaRepository {

    private static final String TABLE_NAME = "tabela_proposta";
    private static final Integer MAX_VALUE_DYNAMO_INSERT = 25;
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;
    private final DynamoDbTable<PropostaEntity> propostaTable;


    public PropostaRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient,
                              DynamoDbTable<PropostaEntity> propostaTable) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
        this.propostaTable = dynamoDbEnhancedClient.table(TABLE_NAME, TableSchema.fromBean(PropostaEntity.class));
    }

    public void salvar(List<PropostaEntity> propostas){

    }
    public List<PropostaEntity> consultar(String idProposta){
        return null;
    }
}
