package grupo.nomeGrupo.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import grupo.nomeGrupo.dto.PessoaDTO;
import grupo.nomeGrupo.entity.Pessoa;
import grupo.nomeGrupo.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepo;

    public List<PessoaDTO> bringAllPessoas() {
        return pessoaRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO findPessoaById(UUID id) {
        Pessoa pessoa = pessoaRepo.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        return convertToDTO(pessoa);
    }

    public PessoaDTO createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = convertToEntity(pessoaDTO);
        Pessoa pessoaSalva = pessoaRepo.save(pessoa);
        return convertToDTO(pessoaSalva);
    }

    private PessoaDTO convertToDTO(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setCpf(pessoa.getCpf());
        dto.setName(pessoa.getName());
        dto.setAge(pessoa.getAge());
        return dto;
    }

    private Pessoa convertToEntity(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setName(pessoaDTO.getName());
        pessoa.setAge(pessoaDTO.getAge());
        return pessoa;
    }
}
