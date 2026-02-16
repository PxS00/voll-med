package med.voll.api.model.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(
        Long id,
        Long idPaciente,
        Long idMedico,
        LocalDateTime data
) {
}
