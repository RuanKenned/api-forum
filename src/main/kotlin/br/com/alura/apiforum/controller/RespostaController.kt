package br.com.alura.apiforum.controller

import br.com.alura.apiforum.model.Resposta
import br.com.alura.apiforum.service.RespostaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/respostas")
class RespostaController(private val service: RespostaService) {

    @GetMapping
    fun findAll(): List<Resposta>{
        return service.findAll();
    }

    @GetMapping("/{topico}")
    fun findByTopico(@PathVariable topico: Long): List<Resposta>{
        return service.findByTopico(topico);
    }
}