package fragmento.cursoandroid.com.divulgaae1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaInicialActivity extends AppCompatActivity {

    private Button botaoLogin;
    private Button botaoCadastrar;
    private ImageView imagemEventos;
    private ImageView imagemContato;
    private ImageView imagemDivulgaae;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        botaoLogin = (Button) findViewById(R.id.btnLoginId);
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaInicialActivity.this, LoginActivity.class));
            }
        });

        botaoCadastrar =(Button) findViewById(R.id.btnCadastrarId);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaInicialActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        imagemEventos = (ImageView) findViewById(R.id.eventoId);
        imagemEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaInicialActivity.this, EventosActivity.class);
                startActivity(intent);
            }
        });

        imagemContato = (ImageView) findViewById(R.id.contatoId);
        imagemContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaInicialActivity.this,ContatoActivity.class));
            }
        });

        imagemDivulgaae = (ImageView) findViewById(R.id.divulgaaeId);
        imagemDivulgaae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TelaInicialActivity.this,DivulgaAEActivity.class));
            }
        });
    }


}
