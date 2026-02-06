plugins {
    id("java")
    application
}

application {
    mainClass.set("com.hugonavarro.tema4gradle.Main")
}

group = "com.hugonavarro.tema4gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.langchain4j:langchain4j-open-ai:1.11.0")
    implementation("dev.langchain4j:langchain4j:1.11.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Exec>("ollamaVersion") {
    commandLine("ollama", "--version")
}

tasks.register<Exec>("ollamaPs") {
    commandLine("ollama", "ps")
}

tasks.register("llmInfo") {
    dependsOn("ollamaVersion", "ollamaPs")
    doLast {
        println("Demo finalizada")
    }
}