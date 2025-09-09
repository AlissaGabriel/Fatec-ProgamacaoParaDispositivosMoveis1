package br.edu.fatecjahu.mensagemapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    /* 1. Criação de uma chave pública (EXTRA_MESSAGE) no formato de String para armazenar o conteúdo da mensagem que será enviada através do botão Send.
       Essa chave pública (EXTRA_MESSAGE) vai ser carregada no objeto intent no metodo putExtra, que levará a mensagem para a próxima tela (DisplayMessageActivity)
    */

    public static final String EXTRA_MESSAGE = "";

    /* 2. Declaração dos objetos Java. */
    TextView tMensagem;
    Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* 3. Associar os elementos de tela (VIEW) aos objetos Java. */
        tMensagem= (TextView) findViewById(R.id.editText1);
        btSend = (Button) findViewById(R.id.btnSend);

        /* 4 Criar o metodo do botão Send. */
        // setOnClickListener => View.OnClickListener() => onClick(View v)
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Faça alguma coisa em resposta ao clique do botão
                // Classe objeto - new Construtor(tela1, tela2)
                // 5. Criar um canal de comunicação chamado intent, que declara a intenção de navegar da tela1 para a tela2
                Intent intent = new Intent(getContext(), DisplayMessageActivity.class);
                // 6. Declara a variavel mensagem para capturar o seu conteúdo.
                String mensagem = tMensagem.getText().toString();
                // 7. Associa a chave pública: EXTRA_MESSAGE ao seu valor que é a variável mensagem. Em seguida, ambas são colocadas dentro do objeto intent.
                intent.putExtra(EXTRA_MESSAGE, mensagem);
                // 8. Por fim, o objeto intent é acionado pelo comando startActivity(intent) para levar um conteúdo para a próxima tela (DisplayMessageActivity);
                startActivity(intent); //
            }
        });
    }

    // private MainActivity getContext()
    private Context getContext() {
        return this;
    }
}