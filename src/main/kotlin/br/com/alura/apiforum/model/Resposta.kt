package br.com.alura.apiforum.model

import br.com.alura.apiforum.dto.TopicoView
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,
    
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    
    @ManyToOne
    val autor: Usuario,
    
    @ManyToOne
    var topico: TopicoView? = null,
    
    val isSolucao: Boolean = false
)
