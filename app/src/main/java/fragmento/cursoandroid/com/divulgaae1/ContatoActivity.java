package fragmento.cursoandroid.com.divulgaae1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContatoActivity extends AppCompatActivity {

    private Button botaoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        botaoEnviar = (Button) findViewById(R.id.btnEviarSugestao);
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContatoActivity.this,TelaInicialActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Enviado com sucesso! Obrigado pelo feedback.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
