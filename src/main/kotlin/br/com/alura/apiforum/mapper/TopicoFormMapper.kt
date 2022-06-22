package br.com.alura.apiforum.mapper

import br.com.alura.apiforum.dto.TopicoForm
import br.com.alura.apiforum.model.Topico
import br.com.alura.apiforum.service.CursoService
import br.com.alura.apiforum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(private val cursoService: CursoService, private val usuarioService: UsuarioService): Mapper<TopicoForm, Topico>{

    override fun map(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.findById(t.idCurso),
            autor = usuarioService.findById(t.idAutor)
        )
    }
}