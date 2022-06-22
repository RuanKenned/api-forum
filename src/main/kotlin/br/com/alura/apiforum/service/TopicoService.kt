package br.com.alura.apiforum.service

import br.com.alura.apiforum.dto.TopicoForm
import br.com.alura.apiforum.dto.TopicoUpdateForm
import br.com.alura.apiforum.dto.TopicoView
import br.com.alura.apiforum.exception.NotFoundException
import br.com.alura.apiforum.mapper.TopicoFormMapper
import br.com.alura.apiforum.mapper.TopicoViewMapper
import br.com.alura.apiforum.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
        private var topicos: List<Topico>,
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoFormMapper: TopicoFormMapper,
        private var notFoundMessage: String?
    ){

    init{
        topicos = ArrayList();
        notFoundMessage = "Tópico não encontrado";
    }

    fun findAll(): List<TopicoView> {
        return this.topicos.stream().map {
                t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList());
    }

    fun findById(idTopico: Long): TopicoView {
        var topico = this.topicos.stream().filter{
                t -> t.id == idTopico
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        };

        return topicoViewMapper.map(topico)
    }

    fun insert(topicoForm: TopicoForm): TopicoView {
        var topico = topicoFormMapper.map(topicoForm);
        topico.id = this.topicos.size.toLong() + 1;
        this.topicos = this.topicos.plus(topico);
        return topicoViewMapper.map(topico);
    }
    
    fun update(topicoUpdateForm: TopicoUpdateForm): TopicoView {
        var topico = this.topicos.stream().filter{
                t -> t.id == topicoUpdateForm.id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        };
        val novoTopico = Topico(
            id = topico.id,
            titulo = topicoUpdateForm.titulo,
            mensagem = topicoUpdateForm.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            status = topico.status,
            respostas = topico.respostas,
            dataCriacao = topico.dataCriacao
        );
        this.topicos = topicos.minus(topico).plus(novoTopico);
        return topicoViewMapper.map(novoTopico);
    }
    
    fun delete(idTopico: Long) {
        var topico = this.topicos.stream().filter{
                t -> t.id == idTopico
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        };
        this.topicos = topicos.minus(topico);
    }
}