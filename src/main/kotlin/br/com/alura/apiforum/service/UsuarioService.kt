package br.com.alura.apiforum.service

import br.com.alura.apiforum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (var usuarios: List<Usuario>) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Ruan Kenned",
            email = "ruan@kenned.com"
        );
        this.usuarios = Arrays.asList(usuario);
    }

    fun findById(id: Long): Usuario{
        return this.usuarios.stream().filter {
                u -> u.id == id
        }.findFirst().get();
    }
}
