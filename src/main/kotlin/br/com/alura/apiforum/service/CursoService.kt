package br.com.alura.apiforum.service

import br.com.alura.apiforum.model.Curso
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CursoService (var cursos: List<Curso>) {
    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        );
        this.cursos = Arrays.asList(curso);
    }

    fun findById(id: Long): Curso{
        return this.cursos.stream().filter {
                c -> c.id == id
        }.findFirst().get();
    }
}
