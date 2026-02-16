package med.voll.api.model.consulta.validacoes;

import med.voll.api.infrastructure.exception.ValidacaoException;
import med.voll.api.model.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo!");
        }
    }
}
