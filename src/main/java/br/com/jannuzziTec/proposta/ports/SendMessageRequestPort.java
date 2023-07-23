package br.com.jannuzziTec.proposta.ports;

import br.com.jannuzziTec.proposta.domain.message.MessageResponse;
import br.com.jannuzziTec.proposta.domain.message.dto.MessageDTO;

@FunctionalInterface
public interface SendMessageRequestPort {
   MessageResponse sendMessage(MessageDTO message);
}
