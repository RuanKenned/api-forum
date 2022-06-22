package br.com.alura.apiforum.dto

import br.com.alura.apiforum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView (
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)
