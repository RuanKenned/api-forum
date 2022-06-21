package br.com.alura.apiforum.service

import br.com.alura.apiforum.model.Curso
import br.com.alura.apiforum.model.Resposta
import br.com.alura.apiforum.model.Topico
import br.com.alura.apiforum.model.Usuario
import org.springframework.stereotype.Service
import java.util.Arrays
import java.util.stream.Collector
import java.util.stream.Collectors

@Service
class RespostaService (private var respostas: List<Resposta>){

    init {
        val ruan = Usuario(
        id = 1,
        nome = "Ruan Kenned",
        email = "ruan@kennedm.com"
        );

        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        val topico1 = Topico(
            id = 1,
            titulo = "Dúvida",
            mensagem = "Variáveis no tópico",
            curso = curso,
            autor = ruan
        );

        val topico2 = Topico(
            id = 2,
            titulo = "Dúvida",
            mensagem = "Variáveis no tópico",
            curso = curso,
            autor = ruan
        );

        val resposta1 = Resposta(
            id = 1,
            mensagem = "Resposta 1",
            autor = ruan,
            isSolucao = false,
            topico = topico1
        );

        val resposta2 = Resposta(
            id = 2,
            mensagem = "Resposta 2",
            autor = ruan,
            isSolucao = false,
            topico = topico2
        )

        respostas = Arrays.asList(resposta1, resposta2);
    }

    fun findAll(): List<Resposta> {
        return this.respostas;
    }

    fun findByTopico(topico: Long): List<Resposta> {
        return this.respostas.stream().filter({
            r -> r.topico.id == topico
        }).collect(Collectors.toList());
    }
}
