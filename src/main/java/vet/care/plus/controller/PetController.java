package vet.care.plus.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vet.care.plus.domain.dto.pet.AtualizacaoPetDto;
import vet.care.plus.domain.dto.pet.CadastroPetDto;
import vet.care.plus.domain.dto.pet.DetalhamentoPetDto;
import vet.care.plus.domain.dto.pet.ListagemPetDto;
import vet.care.plus.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPet(@RequestBody @Valid CadastroPetDto dto) {
        service.cadastrar(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ListagemPetDto>> listarPet() {
        List<ListagemPetDto> lista = service.listar();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhamentoPetDto> detalharPet(@PathVariable Long id) {
        DetalhamentoPetDto pet = service.detalhar(id);
        return ResponseEntity.ok().body(pet);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarPet(@RequestBody AtualizacaoPetDto dto, @PathVariable Long id) {
        service.atualizar(dto, id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarPet(@PathVariable Long id) {
        service.inativar(id);
        return ResponseEntity.noContent().build();
    }

}
