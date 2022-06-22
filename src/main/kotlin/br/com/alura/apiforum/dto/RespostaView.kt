package br.com.alura.apiforum.dto

import java.time.LocalDateTime

data class RespostaView(
    val id: Long?,
    val mensagem: String,
    val isSolucao: Boolean,
    val dataCriacao: LocalDateTime,
    val idTopico: Long?
)
