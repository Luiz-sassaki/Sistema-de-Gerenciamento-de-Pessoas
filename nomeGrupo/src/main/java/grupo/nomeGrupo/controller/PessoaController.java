package grupo.nomeGrupo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grupo.nomeGrupo.dto.PessoaDTO;
import grupo.nomeGrupo.service.PessoaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    private final PessoaService pServ;

    @GetMapping("/todas")
    public ResponseEntity<List<PessoaDTO>> retornaTodasPessoas() {
        return ResponseEntity.ok(pServ.bringAllPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> retornaPessoaPorId(@PathVariable UUID id) {
        PessoaDTO pessoaRetornada = pServ.findPessoaById(id);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRetornada);
    }

    @PostMapping("/salvar")
    public ResponseEntity<PessoaDTO> salvarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        PessoaDTO pessoaSalva = pServ.createPessoa(pessoaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }
}
