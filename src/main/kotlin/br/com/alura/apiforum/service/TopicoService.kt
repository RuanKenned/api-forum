package br.com.alura.apiforum.service

import br.com.alura.apiforum.dto.TopicoForm
import br.com.alura.apiforum.dto.TopicoUpdateForm
import br.com.alura.apiforum.dto.TopicoView
import br.com.alura.apiforum.exception.NotFoundException
import br.com.alura.apiforum.mapper.TopicoFormMapper
import br.com.alura.apiforum.mapper.TopicoViewMapper
import br.com.alura.apiforum.model.Topico
import br.com.alura.apiforum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
        private val repository: TopicoRepository,
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoFormMapper: TopicoFormMapper,
        private var notFoundMessage: String?
    ){

    init{
        notFoundMessage = "Tópico não encontrado";
    }

    fun findAll(): List<TopicoView> {
        return this.repository.findAll().stream().map {
                t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList());
    }

    fun findById(idTopico: Long): TopicoView {
        var topico = this.repository.findById(idTopico).orElseThrow{NotFoundException(notFoundMessage)};
        return topicoViewMapper.map(topico)
    }

    fun insert(topicoForm: TopicoForm): TopicoView {
        var topico = topicoFormMapper.map(topicoForm);
        this.repository.save(topico);
        return topicoViewMapper.map(topico);
    }
    
    fun update(topicoUpdateForm: TopicoUpdateForm): TopicoView {
        var topico = this.repository.findById(topicoUpdateForm.id).orElseThrow{NotFoundException(notFoundMessage)};
        
        topico.titulo = topicoUpdateForm.titulo;
        topico.mensagem = topicoUpdateForm.mensagem;
        
        return topicoViewMapper.map(topico);
    }
    
    fun delete(idTopico: Long) {
        this.repository.deleteById(idTopico);
    }
}