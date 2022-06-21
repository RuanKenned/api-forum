package br.com.alura.apiforum.service

import br.com.alura.apiforum.model.Curso
import br.com.alura.apiforum.model.Topico
import br.com.alura.apiforum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init{
        val topico1 = Topico(
            id = 1,
            titulo = "Dúvida",
            mensagem = "Variáveis no tópico",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ruan Kenned",
                email = "ruan@kennedm.com"
            )
        );

        val topico2 = Topico(
            id = 2,
            titulo = "Dúvida 2",
            mensagem = "Variáveis no tópico 2",
            curso = Curso(
                id = 2,
                nome = "Kotlin 2",
                categoria = "Programação 2"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ruan Kenned 2",
                email = "ruan@kennedm.com 2"
            )
        );

        val topico3 = Topico(
            id = 3,
            titulo = "Dúvida 3",
            mensagem = "Variáveis no tópico 3",
            curso = Curso(
                id = 3,
                nome = "Kotlin 3",
                categoria = "Programação 3"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ruan Kenned 3",
                email = "ruan@kennedm.com 3"
            )
        );
        topicos = Arrays.asList(topico1, topico2, topico3);
    }

    fun findAll(): List<Topico> {
        return this.topicos;
    }

    fun findById(id: Long): Topico {
        return this.topicos.stream().filter({
                t -> t.id == id
        }).findFirst().get();
    }

}