package br.com.alura.apiforum.repository

import br.com.alura.apiforum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {

}