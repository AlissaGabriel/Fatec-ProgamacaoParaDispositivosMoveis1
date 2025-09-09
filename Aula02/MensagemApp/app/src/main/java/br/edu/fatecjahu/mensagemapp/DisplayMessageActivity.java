package br.edu.fatecjahu.mensagemapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_message);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Caputra a intent da Activity (Tela Anterior, MainActivity) e a string EXTRA_MESSAGE que está dentro desse objeto intent.
        Intent intent = getIntent();
        String mensagem = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // 2. Vincular id do arquivo xml (activity_display_message.xml) que está registrado no arquivo R.java junto ao objeto textView da DisplayMessageActivity do Java.
        TextView texto = (TextView) findViewById(R.id.textView1);

        // 3. Define 3 linhas para o objeto java textView.
        texto.setLines(3);

        // 4. Imprime a mensagem que foi enviada pela tela anterior (MainActivity)
        texto.setText(mensagem);

    }
}