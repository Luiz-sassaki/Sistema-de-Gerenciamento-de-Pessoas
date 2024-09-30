package grupo.nomeGrupo.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class PessoaDTO {
    private UUID id;
    private String cpf;
    private String name;
    private Integer age;
}
