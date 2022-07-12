package br.com.alura.apiforum.service

import br.com.alura.apiforum.model.Usuario
import br.com.alura.apiforum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (private val repository: UsuarioRepository) {
   
    fun findById(id: Long): Usuario{
        return repository.findById(id).get();
    }
}
