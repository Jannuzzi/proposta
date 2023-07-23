package br.com.jannuzziTec.proposta.domain.usacases;

import br.com.jannuzziTec.proposta.domain.actions.Action;
import br.com.jannuzziTec.proposta.domain.saga.Saga;
import br.com.jannuzziTec.proposta.domain.saga.SagaValidadores;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MotorSagaImpl implements MotorSagaUseCase {
    @Override
    public Saga enquadrarSaga(final SagaValidadores sagaValidadores) {
        List<Saga> sagaFiltrada = Arrays.stream(Saga.values())
                .filter(saga -> saga.enquadrar(sagaValidadores))
                .filter(saga -> saga.grupo() == sagaValidadores.getSaga().grupo())
                .toList();

        if (sagaFiltrada.size() != 1)
            throw new RuntimeException("Não foi possível enquadrar Saga. Dados Enquadramento: " + sagaValidadores);

        return sagaFiltrada.stream().findFirst().get();
    }

    public static void main(String[] args) {
        final SagaValidadores sagaValidadores = SagaValidadores.of(
                Saga.DEFAULT,
                "C1",
                "1",
                Action.GERAR);

        System.out.println(new MotorSagaImpl().enquadrarSaga(sagaValidadores));
    }
}
