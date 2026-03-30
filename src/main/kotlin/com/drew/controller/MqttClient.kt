package com.drew.controller

import org.springframework.integration.annotation.MessagingGateway
import org.springframework.integration.mqtt.support.MqttHeaders
import org.springframework.messaging.handler.annotation.Header

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
interface MqttClient {
    // O @Header avisa o Spring que essa String é o Tópico MQTT, e não o corpo da mensagem
    fun publicar(@Header(MqttHeaders.TOPIC) topico: String, mensagem: String)
}