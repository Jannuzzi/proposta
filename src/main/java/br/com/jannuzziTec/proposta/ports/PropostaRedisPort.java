package br.com.jannuzziTec.proposta.ports;

import br.com.jannuzziTec.proposta.domain.proposta.Proposta;

public interface PropostaRedisPort {

    void salvar (Proposta proposta);
    Proposta consultar(String idProposta);
}
