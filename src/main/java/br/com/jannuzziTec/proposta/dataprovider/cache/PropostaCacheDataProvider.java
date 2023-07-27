package br.com.jannuzziTec.proposta.dataprovider.cache;

import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.ports.PropostaRedisPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class PropostaCacheDataProvider extends CacheRepositoryAbstract<String, Proposta> implements PropostaRedisPort {

    private static final String KEY_PREFIX = "#PROPOSTA#";

    public PropostaCacheDataProvider(RedisTemplate<String, Object> redisTemplate,
                                     ObjectMapper objectMapper) {
        super(redisTemplate, objectMapper);
    }


    @Override
    public void salvar(Proposta proposta) {
        super.salvarCache(proposta.getIdProposta(), proposta, Duration.ofDays(7L));
    }

    @Override
    public Proposta consultar(String idProposta) {
        return super.consultarCache(idProposta);
    }

    @Override
    String gerarChaveCache(String key) {
        return KEY_PREFIX.concat(key);
    }

    @Override
    Class<Proposta> getClassgenericType() {
        return Proposta.class;
    }
}
