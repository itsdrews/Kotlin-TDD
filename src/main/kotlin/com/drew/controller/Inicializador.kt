package com.drew.controller

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Inicializador(private val sensor: SensorTemperatura) : CommandLineRunner {
    
    override fun run(vararg args: String) {
        println("=========================================")
        println("🚀 INICIANDO SIMULADOR IOT...")
        sensor.enviarLeitura(25.5) // A nossa função que foi testada no TDD!
        println("📡 MENSAGEM MQTT ENVIADA COM SUCESSO!")
        println("=========================================")
    }
}