package com.pascob.start_ai;


public class Test {
    public static void main(String[] args) {
        /* OpenAiApi openAi = new OpenAiApi();
        OpenAiChatModel openAiChatModel = new OpenAiChatModel(
            openAi, 
            OpenAiChatOptions.builder()
                .withModel("gpt-4o-mini")
                .withTemperature(0F)
                .withMaxTokens(300)
                .build()
        );

        String sysMessage = """
                Vous etes un assistant financier specialisé dans l'analyse des chiffres.
                Votre tache est d'extraire les differents chiffres, de les categoriser entre depense et gain, et en fin de donner l'etat du compte
                """;
        SystemMessage systemMessage = new SystemMessage(sysMessage);

        String uMessage = """
                Ce weekend a été dingue. J'ai fait un retrait de 25000 fcfa de mon compte coris.
                J'ai mis essence 2000 fcfa pour mes courses. Mon bb a utilisé environ 5000 fcfa pour la cuisine.
                J'ai recu la visite de mes potes et j'ai ouvert deux bouteilles de vin dont l'unite fait 3500 fcfa.
                Apres nous avons continué en boite, j'avais 6000 fcfa en poche, au retour à la maison, il me restait 3000 fcfa.
                Vraiment il faudrait que j'arrete de sortir
                """;
        UserMessage userMessage  = new UserMessage(uMessage);
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        ChatResponse chatResponse = openAiChatModel.call(prompt);

        System.out.println(chatResponse.getResult().getOutput().getContent()); */
    }
}
