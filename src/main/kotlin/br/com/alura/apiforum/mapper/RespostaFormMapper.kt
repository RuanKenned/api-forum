package br.com.alura.apiforum.mapper

import br.com.alura.apiforum.dto.RespostaForm
import br.com.alura.apiforum.model.Resposta
import br.com.alura.apiforum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper(
    private val usuarioService: UsuarioService): Mapper<RespostaForm, Resposta> {
    override fun map(t: RespostaForm): Resposta {
        return Resposta(
            mensagem = t.mensagem,
            autor = usuarioService.findById(t.idAutor),
        );
    }
}