package br.com.alura.apiforum.model

import java.time.LocalDateTime

data class Resposta (
    val id:Long?,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val topico: Topico,
    val isSolucao: Boolean
)
