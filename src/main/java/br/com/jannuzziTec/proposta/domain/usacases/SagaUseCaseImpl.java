package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.domain.proposta.Proposta;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;
import br.com.jannuzziTec.proposta.ports.SendMessageRequestPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SagaUseCaseImpl implements SagaUseCase<Proposta>{
    private final MotorSagaUseCase motorSagaUseCase;
    private final SendMessageRequestPort sendMessageRequestPort;
    @Override
    public Proposta executar(SagaValidadores sagaValidadores) {

        //Consultar dados complementares

        Saga saga = motorSagaUseCase.enquadrarSaga(sagaValidadores);


        return null;
    }
}
