package med.voll.api.model.consulta;

import java.time.LocalDateTime;

public record DadosListagemConsulta(
        Long id,
        Long idPaciente,
        Long idMedico,
        String nomePaciente,
        String nomeMedico,
        String especialidade,
        LocalDateTime data,
        MotivoCancelamento motivoCancelamento
) {

    public DadosListagemConsulta(Consulta consulta) {
        this(
                consulta.getId(),
                consulta.getPaciente().getId(),
                consulta.getMedico().getId(),
                consulta.getPaciente().getNome(),
                consulta.getMedico().getNome(),
                consulta.getMedico().getEspecialidade().toString(),
                consulta.getData(),
                consulta.getMotivoCancelamento()
        );
    }
}

