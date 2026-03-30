plugins {
	kotlin("jvm") version "2.2.21"
	kotlin("plugin.spring") version "2.2.21"
	id("org.springframework.boot") version "4.0.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.drew"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}
dependencies {
    
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    
    // 1. Protocolo MQTT (A linguagem padrão da IoT)
    implementation("org.springframework.boot:spring-boot-starter-integration")
    implementation("org.springframework.integration:spring-integration-mqtt")
    implementation("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5")

    // 2. Coroutines (Para simular vários dispositivos funcionando ao mesmo tempo)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")

    // 3. Ferramentas essenciais para o nosso TDD
    testImplementation("io.mockk:mockk:1.13.10") // O melhor Mock para Kotlin
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test") // Para testar assincronismo
}
kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
