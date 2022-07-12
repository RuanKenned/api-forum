package br.com.alura.apiforum.repository

import br.com.alura.apiforum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {

}