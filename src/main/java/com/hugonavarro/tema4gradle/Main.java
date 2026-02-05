package com.hugonavarro.tema4gradle;

import dev.langchain4j.model.openai.OpenAiChatModel;

public class Main {
    public static void main(String[] args) {
        // El TOKEN no es necesario para interactuar con modelos locales
        final String TOKEN = "PEGA_AQUI_TU_TOKEN";

        var model1 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey(TOKEN)
                .modelName("gemma:2b")
                .build();

        var model2 = OpenAiChatModel.builder()
                .baseUrl("http://localhost:11434/v1")
                .apiKey(TOKEN)
                .modelName("llama3.1:8b")
                .build();

        String pregunta = model1.chat("Haz una pregunta sobre astronomía");
        String respuesta = model2.chat(pregunta);

        System.out.println("IA 1: " + pregunta);
        System.out.println("IA 2: " + respuesta);
    }
}