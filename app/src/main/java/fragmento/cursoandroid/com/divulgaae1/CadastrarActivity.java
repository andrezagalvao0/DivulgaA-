package fragmento.cursoandroid.com.divulgaae1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        bd = new BDSQLiteHelper(this);

        final EditText nome = (EditText) findViewById(R.id.edtNome);;
        final EditText endereco = (EditText) findViewById(R.id.edtEndereco);
        //final EditText dia = (EditText)  findViewById(R.id.edtDia);


        Button salvar = (Button) findViewById(R.id.btnSalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Evento evento = new Evento();
                evento.setNome(nome.getText().toString());
                evento.setEndereco(endereco.getText().toString());
                //evento.setDia(Integer.parseInt(dia.getText().toString()));

                bd.addEvento(evento);

                Intent intent = new Intent(CadastrarActivity.this, TelaInicialActivity.class);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Evento inserido com sucesso", Toast.LENGTH_SHORT).show();
            }


        });

    }
}
