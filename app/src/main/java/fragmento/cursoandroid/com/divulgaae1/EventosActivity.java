package fragmento.cursoandroid.com.divulgaae1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventosActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;
    ArrayList<Evento> listaEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bd = new BDSQLiteHelper(this);
        setContentView(R.layout.activity_eventos);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView lista = (ListView) findViewById(R.id.lvEventos);
        listaEventos = bd.getAllEventos();
        EventoAdapter adapter = new EventoAdapter(this, listaEventos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(EventosActivity.this, EditarEventoActivity.class);
                intent.putExtra("ID", listaEventos.get(i).getId());
                startActivity(intent);


            }
        });
    }

}



