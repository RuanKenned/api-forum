package br.com.alura.apiforum.controller

import br.com.alura.apiforum.model.Curso
import br.com.alura.apiforum.model.Topico
import br.com.alura.apiforum.model.Usuario
import br.com.alura.apiforum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService){

    @GetMapping
    fun findAll(): List<Topico>{
        return service.findAll();
    };

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Topico{
        return service.findById(id);
    }
}