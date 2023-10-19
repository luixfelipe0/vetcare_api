package vet.care.plus.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vet.care.plus.domain.dto.vet.AtualizacaoVetDto;
import vet.care.plus.domain.dto.vet.CadastroVetDto;
import vet.care.plus.domain.dto.vet.DetalhamentoVetDto;
import vet.care.plus.domain.dto.vet.ListagemVetDto;
import vet.care.plus.service.VetService;

import java.util.List;

@RestController
@RequestMapping("/vet")
public class VetController {

    @Autowired
    private VetService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarVet(@Valid @RequestBody CadastroVetDto dto) {
        service.cadastrar(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ListagemVetDto>> listarVet() {
        List<ListagemVetDto> lista = service.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoVetDto> detalharVet(@PathVariable Long id) {
        DetalhamentoVetDto vet = service.detalhar(id);
        return ResponseEntity.ok(vet);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarVet(@RequestBody AtualizacaoVetDto dto, @PathVariable Long id) {
        service.atualizar(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarVet(@PathVariable Long id) {
        service.inativar(id);
        return ResponseEntity.noContent().build();
    }

}
