package fragmento.cursoandroid.com.divulgaae1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarEventoActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_evento);


        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0);
        bd = new BDSQLiteHelper(this);
        final Evento evento = bd.getEvento(id);

        final EditText nome = (EditText) findViewById(R.id.edtNome);
        final EditText endereco = (EditText) findViewById(R.id.edtEndereco);
        //final EditText dia = (EditText) findViewById(R.id.edtDia);


        //adicionar tudo que for alterar

        nome.setText(evento.getNome());
        endereco.setText(evento.getEndereco());
        //dia.setText(evento.getDia());


        Button alterar = (Button) findViewById((R.id.btnAlterar));
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                evento.setNome(nome.getText().toString());
                evento.setEndereco(endereco.getText().toString());
                //evento.setDia(Integer.parseInt(dia.getText().toString()));

                bd.updateEvento(evento);
                Intent intent = new Intent(EditarEventoActivity.this, TelaInicialActivity.class);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Evento alterado com sucesso.", Toast.LENGTH_SHORT).show();

            }
        });

        Button remover = (Button) findViewById((R.id.btnRemover));
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bd.deleteEvento(evento);
                Intent intent = new Intent(EditarEventoActivity.this, TelaInicialActivity.class);
                startActivity(intent);
                Toast.makeText(getBaseContext(), "Evento removido com sucesso.", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
