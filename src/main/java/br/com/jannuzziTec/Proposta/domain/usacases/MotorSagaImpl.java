package br.com.jannuzziTec.Proposta.domain.usacases;

import br.com.jannuzziTec.Proposta.domain.actions.Action;
import br.com.jannuzziTec.Proposta.domain.saga.Saga;
import br.com.jannuzziTec.Proposta.domain.saga.SagaValidadores;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MotorSagaImpl implements IMotorSaga {
    @Override
    public Saga enquadrarSaga(SagaValidadores sagaValidadores) {
        List<Saga> sagaFiltrada = Arrays.stream(Saga.values())
                .filter(saga -> saga.enquadrar(sagaValidadores))
                .filter(saga -> saga.grupo() == sagaValidadores.getSaga().grupo())
                .toList();

        if (sagaFiltrada.size() != 1)
            throw new RuntimeException("Não foi possível enquadrar Saga. Dados Enquadramento: " + sagaValidadores);

        return sagaFiltrada.get(0);
    }

    public static void main(String[] args) {
        SagaValidadores sagaValidadores = SagaValidadores.of(
                Saga.DEFAULT,
                "C1",
                "1",
                Action.GERAR);

        System.out.println(new MotorSagaImpl().enquadrarSaga(sagaValidadores));
    }
}
