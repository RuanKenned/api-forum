package br.com.alura.apiforum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class RespostaUpdateForm (
    @field: NotNull
    val id: Long,
    
    @field: NotEmpty
    @field: Size(min = 5, max = 100)
    val mensagem: String
)