package br.com.alura.apiforum.model

import br.com.alura.apiforum.dto.TopicoView
import java.time.LocalDateTime

data class Resposta (
    var id:Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    var topico: TopicoView? = null,
    val isSolucao: Boolean = false
)
