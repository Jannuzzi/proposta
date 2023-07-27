package br.com.jannuzziTec.proposta.ports;

import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.entrypoint.controller.model.PropostaInput;

import java.math.BigInteger;

public interface PropostaDynamoDbPort {

    void salvar(Proposta proposta);

    Proposta consultar(String idProposta);

    void atualizar(Proposta proposta);
}
