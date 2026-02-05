package med.voll.api.model.medico;


import med.voll.api.model.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String telefone, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
