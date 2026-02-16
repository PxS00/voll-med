package med.voll.api.model.consulta.validacoes;

import med.voll.api.infrastructure.exception.ValidacaoException;
import med.voll.api.model.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.ConsultaRepository;

public class ValidadorPacienteSemOutraConsultaDia {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if(pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já possui outra consulta agendada nesse dia");
        }

    }
}
