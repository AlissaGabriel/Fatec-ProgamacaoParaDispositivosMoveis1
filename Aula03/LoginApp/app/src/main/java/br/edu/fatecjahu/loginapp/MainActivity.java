package br.edu.fatecjahu.loginapp;

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


    // 0. Criar os objetos Java
    TextView tLogin, tSenha;
    Button btLogin;

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

        // 1. Cria o objeto btLogin do tipo Button e vinculo ao botão btnLogin da Activity(tela).
        btLogin = (Button) findViewById(R.id.btnLogin);

        // 2. Metodo do botão "Login"
        // setOnClickListener => View.OnClickListener() => onClick(View v)
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Associar os objetos da View com os objetos Java.
                tLogin = (TextView) findViewById(R.id.edtUsuario);
                tSenha = (TextView) findViewById(R.id.edtSenha);

                // 4. Criação do Usuário e Senha Padrão
                final String LOGIN = "alissa"; // Constante LOGIN é o nome do usuário.
                final String SENHA = "12345"; // Constante SENHA é a senha do usuário.

                // 5. Capturar usuário e senha.
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();
            }
        });
    }
}