package br.com.jannuzziTec.proposta.ports;

import br.com.jannuzziTec.proposta.entrypoint.controller.model.PropostaInput;

import java.math.BigInteger;

public interface PropostaDynamoDbPort {

    BigInteger salvar(PropostaInput propostaInput);
}
