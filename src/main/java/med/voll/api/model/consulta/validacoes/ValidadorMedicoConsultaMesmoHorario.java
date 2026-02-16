package med.voll.api.model.consulta.validacoes;

import med.voll.api.infrastructure.exception.ValidacaoException;
import med.voll.api.model.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.ConsultaRepository;

public class ValidadorMedicoConsultaMesmoHorario {

    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiConsultaNoMesmoHorario){
            throw new ValidacaoException("Médico já possui consulta agendada nesse mesmo horário!");
        }
    }
}
