package br.com.alura.apiforum.controller

import br.com.alura.apiforum.dto.*
import br.com.alura.apiforum.service.RespostaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping
    fun findAll(): List<RespostaView>{
        return service.findAll();
    }

    @GetMapping("/{idTopico}")
    fun findByIdTopico(@PathVariable idTopico: Long): List<RespostaView>{
        return service.findByIdTopico(idTopico);
    }

    @PostMapping
    fun insert(@RequestBody @Valid respostaForm: RespostaForm, uriBuilder: UriComponentsBuilder): ResponseEntity<RespostaView> {
        var respostaView = service.insert(respostaForm);
        val uri = uriBuilder.path("/respostas/${respostaView.idTopico}").build().toUri();
        return ResponseEntity.created(uri).body(respostaView);
    }
    
    @PutMapping
    fun update(@RequestBody @Valid respostaForm: RespostaUpdateForm, uriBuilder: UriComponentsBuilder): ResponseEntity<RespostaView>{
        val respostaView = service.update(respostaForm);
        return ResponseEntity.ok(respostaView);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        return service.delete(id);
    }
}