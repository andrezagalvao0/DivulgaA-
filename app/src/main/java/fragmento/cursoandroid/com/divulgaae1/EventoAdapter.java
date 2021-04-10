package fragmento.cursoandroid.com.divulgaae1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Valdson on 03/03/2018.
 */
public class EventoAdapter extends ArrayAdapter<Evento> {

    private final Context context;
    private final ArrayList<Evento> elementos;

    public EventoAdapter(Context context, ArrayList<Evento> elementos) {
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView nomeEvento = (TextView) rowView.findViewById(R.id.nome);
        TextView endereco = (TextView) rowView.findViewById(R.id.Endereco);
        //TextView dia = (TextView) rowView.findViewById (R.id.edtDia);

        nomeEvento.setText(elementos.get(position).getNome());
        endereco.setText(elementos.get(position).getEndereco());
        //dia.setText(elementos.get(position).getDia());

        return rowView;
    }

}
