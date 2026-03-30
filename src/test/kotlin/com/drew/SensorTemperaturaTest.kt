package com.drew
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class SensorTemperaturaTest {

    @Test
    fun `deve ler a temperatura e enviar para o broker mqtt`() {
        // 1. Arrange (Preparação)
        // Criamos um "MqttClient" falso (Mock) usando o MockK. 
        // O "relaxed = true" diz ao mock para não dar erro se chamarmos métodos que não configuramos.
        val clienteMqttMock = mockk<MqttClient>(relaxed = true)
        
        // Instanciamos o nosso sensor passando o cliente falso para ele (Injeção de Dependência)
        val sensor = SensorTemperatura(clienteMqttMock)

        // 2. Act (Ação)
        // Mandamos o sensor registrar e enviar uma temperatura de 25.5 graus
        sensor.enviarLeitura(25.5)

        // 3. Assert (Verificação)
        // Verificamos se o nosso sensor realmente chamou o cliente MQTT para publicar a mensagem
        verify(exactly = 1) { 
            clienteMqttMock.publicar("dispositivos/sensor-temp/tx", "25.5") 
        }
    }
}