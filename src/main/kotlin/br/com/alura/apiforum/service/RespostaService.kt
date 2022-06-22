package br.com.alura.apiforum.service

import br.com.alura.apiforum.dto.RespostaForm
import br.com.alura.apiforum.dto.RespostaUpdateForm
import br.com.alura.apiforum.dto.RespostaView
import br.com.alura.apiforum.exception.NotFoundException
import br.com.alura.apiforum.mapper.RespostaFormMapper
import br.com.alura.apiforum.mapper.RespostaViewMapper
import br.com.alura.apiforum.model.Resposta
import br.com.alura.apiforum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService (
        private var respostas: List<Resposta>,
        private var respostaFormMapper: RespostaFormMapper,
        private var respostaViewMapper: RespostaViewMapper,
        private var topicoService: TopicoService,
        private var notFoundMessage: String?
    ){

    init {
        respostas = ArrayList();
        notFoundMessage = "Tópico não encontrado";
    }

    fun findAll(): List<RespostaView> {
        return this.respostas.stream().map {
            r -> respostaViewMapper.map(r)
        }.collect(Collectors.toList());
    }

    fun findByIdTopico(idTopico: Long): List<RespostaView> {
        var auxRespostas =  this.respostas.stream().filter{
            r -> r.topico?.id == idTopico
        }.collect(Collectors.toList());

        return auxRespostas.stream().map {
                r -> respostaViewMapper.map(r)
        }.collect(Collectors.toList());
    }

    fun insert(respostaForm: RespostaForm): RespostaView {
        var resposta = respostaFormMapper.map(respostaForm);
        resposta.id = this.respostas.size.toLong() + 1;
        resposta.topico = topicoService.findById(respostaForm.idTopico);
        this.respostas = this.respostas.plus(resposta);
        return respostaViewMapper.map(resposta);
    }
    
    fun update(respostaUpdateForm: RespostaUpdateForm): RespostaView {
        var resposta = this.respostas.stream().filter{
                t -> t.id == respostaUpdateForm.id
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        };
        val novaResposta = Resposta(
            id = resposta.id,
            mensagem = respostaUpdateForm.mensagem,
            autor = resposta.autor,
            topico = resposta.topico,
            dataCriacao = resposta.dataCriacao,
            isSolucao = resposta.isSolucao
        );
        this.respostas = respostas.minus(resposta).plus(novaResposta);
        return respostaViewMapper.map(novaResposta);
    }
    
    fun delete(idResposta: Long) {
        var resposta = this.respostas.stream().filter{
                t -> t.id == idResposta
        }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        };
        this.respostas = respostas.minus(resposta);
    }
}
