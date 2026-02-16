package med.voll.api.model.consulta.validacoes;

import med.voll.api.infrastructure.exception.ValidacaoException;
import med.voll.api.model.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidacaoHorarioFuncionamento {

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dataConsulta.getHour() < 7;
        var depoisDoFechamento = dataConsulta.getHour() > 18;

        if (domingo || antesDaAbertura || depoisDoFechamento){
            throw new ValidacaoException("Consulta fora do horário de funcionamento!");
        }
    }

}
