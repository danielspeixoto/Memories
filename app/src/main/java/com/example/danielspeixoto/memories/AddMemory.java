package com.example.danielspeixoto.memories;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMemory extends AppCompatActivity {

    private EditText titleInput;
    private EditText descriptionInput;
    private Button saveMemory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memory);
        titleInput = (EditText) findViewById(R.id.titleInput);
        descriptionInput = (EditText) findViewById(R.id.descriptionInput);
        saveMemory = (Button) findViewById(R.id.saveMemory);

        // Uma diferente forma de gerenciar cliques é setando onClickListeners nas views
        saveMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recebemos o texto que está no input designado pro título. Lembre-se de o
                // converter para String, o retorno de getText() é um Editable, após getText()
                // use toString()
                String title = titleInput.getText().toString();
                // O mesmo processo ocorre aqui
                String description = descriptionInput.getText().toString();
                // Através das informações recebidas, criamos um objeto do tipo Memory, que
                // é a memória que queremos salvar
                Memory memory = new Memory(title, description);
                // Ela é adicionada à Lista de memórias que está na classe MainActivity
                MainActivity.memories.add(memory);
                // Agora limpamos os campos, pondo um texto vazio em cada um dos inputs
                titleInput.setText("");
                descriptionInput.setText("");
                // O usuário precisa saber que o processo deu certo para isso usamos uma Toast
                // Através da função makeText, passamos o atual contexto, a mensagem, e a duração
                // do Toast, feito isso, mandamos ele aparecer usando show()
                Toast.makeText(AddMemory.this, "Salvo", Toast.LENGTH_SHORT).show();
                // O log é muito útil para recebermos informações do que está acontecendo, sem
                // atrapalhar a experiência no uso do app, ele imprime as informações no Android
                // Monitor. Para o usar são passados uma tag e a informação desejada (ambas do
                // tipo String)
                Log.i("Memória criada", memory.getTitle());
            }
        });
    }
}
