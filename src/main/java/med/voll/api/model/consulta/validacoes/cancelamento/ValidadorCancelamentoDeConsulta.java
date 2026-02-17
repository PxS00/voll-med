package med.voll.api.model.consulta.validacoes.cancelamento;

import med.voll.api.model.consulta.Consulta;
import med.voll.api.model.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsulta dados, Consulta consulta);
}
