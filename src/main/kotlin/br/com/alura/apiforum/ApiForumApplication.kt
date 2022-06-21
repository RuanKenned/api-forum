package br.com.alura.apiforum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiForumApplication

fun main(args: Array<String>) {
	runApplication<ApiForumApplication>(*args)
}
