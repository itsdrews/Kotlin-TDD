package com.drew.controller

import org.springframework.stereotype.Component

@Component
class SensorTemperatura(private val mqttClient: MqttClient) {

    fun enviarLeitura(temperatura: Double) {

        // Converter o Double para String e enviar para o tópico correto
        mqttClient.publicar("dispositivos/sensor-temp/tx", temperatura.toString())
    }
}