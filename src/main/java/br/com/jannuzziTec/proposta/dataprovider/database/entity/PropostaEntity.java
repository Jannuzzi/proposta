package br.com.jannuzziTec.proposta.dataprovider.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Data
@Builder
@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
public class PropostaEntity {

    private String chaveParticao;
    private String chaveFiltragem;
    private String saga;


    @DynamoDbPartitionKey
    @DynamoDbAttribute("cod_chav_patc")
    public String getChaveParticao(){
        return chaveParticao;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("cod_chav_filg")
    public String getChaveFiltragem(){
        return chaveFiltragem;
    }

    @DynamoDbAttribute("saga")
    public String getSaga() {
        return saga;
    }
}
