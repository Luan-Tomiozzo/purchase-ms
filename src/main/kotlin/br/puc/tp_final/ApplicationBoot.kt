package br.puc.tp_final

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class ApplicationBoot {}

fun main(args: Array<String>) {
    runApplication<ApplicationBoot>(*args)
}