package vet.care.plus.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vet.care.plus.domain.dto.tutor.AtualizacaoTutorDto;
import vet.care.plus.domain.dto.tutor.CadastroTutorDto;
import vet.care.plus.domain.dto.tutor.DetalhamentoTutorDto;
import vet.care.plus.domain.dto.tutor.ListagemTutorDto;
import vet.care.plus.service.TutorService;

import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    private TutorService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTutor(@Valid @RequestBody CadastroTutorDto dto) {
        service.cadastrar(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ListagemTutorDto>> listarTutor() {
        List<ListagemTutorDto> lista = service.listar();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoTutorDto> detalharTutor(@PathVariable Long id) {
        DetalhamentoTutorDto tutor = service.detalhar(id);
        return ResponseEntity.ok().body(tutor);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AtualizacaoTutorDto> atualizarTutor(@RequestBody AtualizacaoTutorDto dto, @PathVariable Long id) {
        service.atualizar(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarTutor(@PathVariable Long id) {
        service.inativar(id);
        return ResponseEntity.noContent().build();
    }

}
