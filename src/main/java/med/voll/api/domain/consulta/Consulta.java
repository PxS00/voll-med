package med.voll.api.domain.consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.infrastructure.exception.ValidacaoException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;
import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @Column(name = "data_consulta")
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    @Column(name = "motivo_cancelamento")
    private MotivoCancelamento motivoCancelamento;


    public void cancelar(MotivoCancelamento motivoCancelamento) {

        if (this.motivoCancelamento != null) {
            throw new ValidacaoException("Consulta já está cancelada!");
        }

        if (motivoCancelamento == null) {
            throw new ValidacaoException("Motivo do cancelamento é obrigatório");
        }
        this.motivoCancelamento = motivoCancelamento;
    }
}
