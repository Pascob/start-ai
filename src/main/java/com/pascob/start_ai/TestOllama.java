package com.pascob.start_ai;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import java.util.List;

public class TestOllama {
    public static void main(String[] args) {
        OllamaApi ollamaApi = new OllamaApi();
        OllamaChatModel chatModel = new OllamaChatModel(
            ollamaApi, 
            OllamaOptions.create()
                .withModel("llama3.1")
                // .withModel("mistral")
                .withTemperature(0F)
        );

        String sysMessage = """
                Vous etes un assistant financier specialisé dans l'analyse des chiffres.
                Votre tache est d'extraire les differents chiffres, de les categoriser entre depense et gain, et en fin de donner l'etat du compte
                """;
        SystemMessage systemMessage = new SystemMessage(sysMessage);

        String uMessage = """
                Ce weekend a été dingue. J'ai fait un retrait 25000 fcfa pour le weekend.
                J'ai mis essence 2000 fcfa pour mes courses. Mon bb a utilisé environ 5000 fcfa pour la cuisine.
                J'ai recu la visite de mes potes et j'ai ouvert deux bouteilles de vin dont une bouteille coute 3500 fcfa.
                Apres nous avons continué en boite, j'ai pris 6000 fcfa pour la sortie j'ai reellement depensé 3000 fcfa.
                Vraiment il faudrait que j'arrete de sortir
                """;
        UserMessage userMessage  = new UserMessage(uMessage);

        String uReponse = """
                1. Dépenses :
                    Essence : -2000
                    Cuisine : -5000
                    Bouteilles de vin : -7000
                    Boîte de nuit : -3000
                
                2. Gains :
                    Compte : +25000

                3. Résumé de l'état du compte :
                    Total des gains : 25000
                    Total des dépenses : 17000
                    Solde restant : 8000
                """;
        
        AssistantMessage aMessage = new AssistantMessage(uReponse);

        String uMessage1 = """
                Donald avait 50000 fcfa pour le weekend.
                Il est allé voir sa grand-mere et lui a donné 5000 fcfa.
                Il a achété de la viande de porc à 2000 fcfa et a bu deux bouteille de beaufort dont chaque bouteille coute 750 fcfa.
                De retour pour la maison, il a brulé le feu de stop et les ploiciers lui ont fait payé 6000 fcfa comme contravention.
                """; 
        
        UserMessage userMessage2  = new UserMessage(uMessage1);
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage, aMessage, userMessage2));
        ChatResponse chatResponse = chatModel.call(prompt);

        System.out.println(chatResponse.getResult().getOutput().getContent());
    }
}
