package br.com.alura.apiforum.repository

import br.com.alura.apiforum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {

}