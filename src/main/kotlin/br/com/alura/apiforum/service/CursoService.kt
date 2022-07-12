package br.com.alura.apiforum.service

import br.com.alura.apiforum.model.Curso
import br.com.alura.apiforum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CursoService (private val repository: CursoRepository) {
   
    fun findById(id: Long): Curso{
        return repository.findById(id).get()
    }
}
