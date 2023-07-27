package br.com.jannuzziTec.proposta.dataprovider.database;

import br.com.jannuzziTec.proposta.dataprovider.database.PropostaRepository;
import br.com.jannuzziTec.proposta.dataprovider.database.entity.PropostaEntity;
import br.com.jannuzziTec.proposta.dataprovider.database.type.PropostaEntityFactory;
import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.ports.PropostaDynamoDbPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
@Service
public class PropostaDynamoDBDataProvider implements PropostaDynamoDbPort {
    private final PropostaRepository propostaRepository;

    public void salvar(Proposta proposta){
        try {
            //TODO validar se essa implementacao funciona
            AtomicReference<List<PropostaEntity>> propostaEntityList = new AtomicReference<>();
            PropostaEntityFactory.entityTypeMap
                    .stream()
                    .map(entityType -> entityType.criarEntity(proposta))
                    .peek(propostaEntityList::set);

            propostaRepository.salvar(propostaEntityList.get());
        } catch (Exception e) {
            throw new IllegalArgumentException("erro ao salvar objeto", e);
        }
    }

    public final Proposta consultar(String idProposta){
        // TODO implementar
        List<PropostaEntity> consultar = propostaRepository.consultar(idProposta);
        return null;
    }

    @Override
    public void atualizar(Proposta proposta) {

    }
}
