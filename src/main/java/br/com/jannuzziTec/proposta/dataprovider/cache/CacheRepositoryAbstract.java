package br.com.jannuzziTec.proposta.dataprovider.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class CacheRepositoryAbstract<K,V> {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    protected final void salvar(K key, V value, Duration expireDuration){
        try {
            redisTemplate.opsForValue()
                    .set(gerarChaveCache(key),
                            objectMapper.writeValueAsString(value),
                            expireDuration);
        }catch (Exception e) {
            throw new IllegalArgumentException("erro ao salvar objeto", e);
        }
    }

    protected final V consultar(K key){
        Object cacheObj = redisTemplate.opsForValue().get(gerarChaveCache(key));
        return Optional.ofNullable(cacheObj)
                .map(value -> {
                    try {
                        return objectMapper.readValue((String) value, getClassgenericType());
                    } catch (JsonProcessingException e) {
                        throw new IllegalArgumentException("erro ao consultar", e);
                    }
                }).orElseThrow(RuntimeException::new);
    }

    abstract String gerarChaveCache(K key);
    abstract Class<V> getClassgenericType();
}
