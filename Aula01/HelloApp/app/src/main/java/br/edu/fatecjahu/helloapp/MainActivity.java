package br.edu.fatecjahu.helloapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1. Criar os objetos Java.
    Button btTraduzir;
    TextView tSaudacao;

    Button btReiniciar;


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

        // 2. Associar o objeto Java: btTrazudir
        // ao componente de tela: btnTrazudir
        btTraduzir = (Button) findViewById(R.id.btnTraduzir);

        // 2.1. Associar o objeto Java: tSaudacao
        // ao componente de tela: tvSaudacao
        tSaudacao = (TextView) findViewById(R.id.tvSaudacao);

        //definir o tanto de linhas que ira utilizar
        //ex: vai ter uma altura de duas linhas.
        tSaudacao.setLines(2);
        //centralizar manualmente
        tSaudacao.setGravity(Gravity.CENTER);

        // 2.2. Associar o objeto Java: btReiniciar
        // ao componente de tela: btnReiniciar
        btReiniciar = (Button) findViewById(R.id.btnReiniciar);

        // 3. Ciar o metodo do botao Traduzir.|
        btTraduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tSaudacao.setText(R.string.texto_portugues);
                tSaudacao.setTextColor(getColor(R.color.white));
            }
        });

        //4 Criar o metodo do botao Reiniciar
        btReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tSaudacao.setText("Hello \nWord!");
                //tSaudacao.setText(R.string.texto_ingles);
                tSaudacao.setTextColor(getColor(R.color.black));
                tSaudacao.setBackgroundColor(getColor(R.color.lilac));
            }
        });
    }
}