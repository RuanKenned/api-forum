package br.com.alura.apiforum.mapper

import br.com.alura.apiforum.dto.RespostaView
import br.com.alura.apiforum.model.Resposta
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper(): Mapper<Resposta, RespostaView> {
    override fun map(t: Resposta): RespostaView {
        return RespostaView(
            id = t.id,
            mensagem = t.mensagem,
            isSolucao = t.isSolucao,
            dataCriacao = t.dataCriacao,
            idTopico = t.topico?.id
        );
    }
}