package med.voll.api.model.consulta.validacoes;

import med.voll.api.infrastructure.exception.ValidacaoException;
import med.voll.api.model.consulta.DadosAgendamentoConsulta;
import med.voll.api.repository.MedicoRepository;

public class ValidadorMedicoAtivo {

    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados){

        if(dados.idMedico() == null){
            return;
        }

        var medicoAtivo = medicoRepository.findAtivoById(dados.idMedico());

        if (!medicoAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com médico inativo!");
        }
    }
}
