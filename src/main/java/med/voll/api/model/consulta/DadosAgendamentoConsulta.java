package med.voll.api.model.consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.model.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        @NotNull
        Long idPaciente,
        Long idMedico,

        @NotNull
        @Future
        LocalDateTime data,

        Especialidade especialidade
) {
}
