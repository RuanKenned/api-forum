package br.com.alura.apiforum.controller

import br.com.alura.apiforum.dto.TopicoForm
import br.com.alura.apiforum.dto.TopicoUpdateForm
import br.com.alura.apiforum.dto.TopicoView
import br.com.alura.apiforum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService){

    @GetMapping
    fun findAll(): List<TopicoView>{
        return service.findAll();
    };

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicoView {
        return service.findById(id);
    }

    @PostMapping
    @Transactional
    fun insert(@RequestBody @Valid topicoForm: TopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView>{
        val topicoView = service.insert(topicoForm);
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri();
        return ResponseEntity.created(uri).body(topicoView);
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid topicoForm: TopicoUpdateForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView>{
        val topicoView = service.update(topicoForm);
        return ResponseEntity.ok(topicoView);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun delete(@PathVariable id: Long) {
        return service.delete(id);
    }
}