package com.example.danielspeixoto.memories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // As variáveis são declaradas fora para que possam ser acessadas em qualquer parte do código
    public static ArrayList<Memory> memories;
    private ListView listMemories;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // A superclasse é chamada para executar o que já é pré-definido, o que quisermos incrementar
        // colocaremos em seguida
        super.onCreate(savedInstanceState);
        // O layout desejado é associado à esta classe afim de ser usado quando essa classe for criada
        setContentView(R.layout.activity_main);
        // As views são resgatas através dos seus ids. Deve-se colocar o tipo delas ao lado direito
        // pois o método retorna uma view, você precisa dizer qual tipo de view és
        listMemories = (ListView) findViewById(R.id.listMemories);
        // O ArrayList será usado para alocarmos itens dinamicamente
        memories = new ArrayList<>();
        // O ArrayAdapter é quem conecta o ArrayList com a ListView, ele explica como os items serão
        // alocados no ListView
        // São recebidos 3 parâmetros : Contexto, Layout e Array. Para o contexto, eu recomendo usar
        // AlgumaClass.this para evitar bugs, mas também é possível o generalizar mais usando
        // getBaseCOntext()
        adapter = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, memories);
        // O ListView é associado ao seu ArrayAdapter
        listMemories.setAdapter(adapter);
        // Dizemos o que acontece quando um item da ListView é clicado
        listMemories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // OnItemClick nos passa algumas informações como o Container do item, o item em si
            // sua posição na lista e o seu id (posição no ArrayList)(position e id podem diferir
            // caso haja mais views dentro da ListView
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // A intent é usada para nos enviar para outro lugar, por exemplo, outra Activity
                // Recebe como parâmetros: Contexto e classe dejada
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                // Como desejamos visualizar as informações da memória selecionada usaremos o id que
                // foi passado no clique para selecionar a memória clicada
                Memory memory = memories.get((int) id);
                // A intent é capaz de passar informações consigo, para isso é usada a função
                // putExtra(String tag, informação) em que informação pode ser uma variedade de tipos
                // diferentes de data (String, int, Bundle, Byte[], etc)
                i.putExtra("title", memory.getTitle());
                i.putExtra("description", memory.getDescription());
                // Ao final das configurações serem feitas, mandamos a intent nos levar ao lugar
                // ordenado
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        // Assim como onCreate() também chamaremos o metódo da superclasse aqui
        super.onResume();
        // É possível que enquanto essa classe estava inativa, mais itens terem sido adicionados
        // porém o ArrayAdapter ainda não está ciente disso, para fazer que ele atualize suas
        // informações fazemos como abaixo
        adapter.notifyDataSetChanged();
    }

    // Este metódo é chamado pelo Button no XML, mas ele é implementado aqui
    public void putOnList (View view) {
        // Novamente, a Intent é usada para nos direcionar à um lugar diferente, neste caso à classe
        // que vai gerenciar as novas adições à lista de memórias
        Intent i = new Intent(MainActivity.this, AddMemory.class);
        startActivity(i);
    }
}
