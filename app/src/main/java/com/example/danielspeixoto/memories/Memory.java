package com.example.danielspeixoto.memories;

/**
 * Created by danielspeixoto on 18/09/16.
 */
// Ensinamos ao nosso app, o que é uma memória
public class Memory {
    // Os atributos de uma memória
    private String title;
    private String description;

    // Para uma memória ser criada ela precisa de um título e uma descrição
    // por isso esses são parâmetros do seu construtor
    public Memory(String title, String description) {

        this.title = title;
        this.description = description;
    }

    // Usamos Getters para receber informações sobre as memórias
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // Vamos sobrescrever o metódo toString() para passarmos a informação desejada a ser mostrada
    // na ListView, repare que você também pode dar uma sinopse da descrição da Memória usando
    // concatenação. Descomente a linha abaixo, comente a padrão e veja o resultado
    @Override
    public String toString() {
        // return "#" + title + "\n" + description.substring(0, 50);
        return title;
    }

}
