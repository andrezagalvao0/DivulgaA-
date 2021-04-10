package fragmento.cursoandroid.com.divulgaae1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Valdson on 03/03/2018.
 */
public class BDSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "EventoDB";

    private static final String TABELA_EVENTOS = "eventos";
    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String ENDERECO = "endereço";
   // private static final String DIA = "dia";



    private static final String[] COLUNAS = {ID, NOME, ENDERECO,/* DIA*/};




    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE eventos ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nome TEXT," +
                "endereço TEXT)";// +
                //"dia INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS eventos");
        this.onCreate(db);

    }
    public void addEvento(Evento evento) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        ;
        values.put(NOME, evento.getNome());
        values.put(ENDERECO, evento.getEndereco());
        //values.put(DIA, new Integer(evento.getDia()));

        db.insert(TABELA_EVENTOS, null, values); //insere o registro
        db.close();
    }

    public Evento getEvento(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_EVENTOS, // a. tabela
                COLUNAS, // b. colunas
                " id = ?", // c. colunas para comparar
                new String[]{String.valueOf(id)}, // d. parâmetros
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        if (cursor == null) {
            return null;
        } else {
            cursor.moveToFirst();
            Evento evento = cursorToEvento(cursor);
            return evento;
        }
    }

    private Evento cursorToEvento(Cursor cursor) {
        Evento evento = new Evento();
        evento.setId(Integer.parseInt(cursor.getString(0)));
        evento.setNome(cursor.getString(1));
        evento.setEndereco(cursor.getString(2));
        //evento.setDia(Integer.parseInt(cursor.getString(3)));
        return evento;
    }

    public ArrayList<Evento> getAllEventos() {
        ArrayList<Evento> listaEventos = new ArrayList<Evento>();

        String query = "SELECT * FROM " + TABELA_EVENTOS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Evento evento = cursorToEvento(cursor);
                listaEventos.add(evento);
            } while (cursor.moveToNext());
        }
        return listaEventos;
    }

    public int updateEvento(Evento evento) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NOME, evento.getNome());
        values.put(ENDERECO, evento.getEndereco());
       // values.put(DIA, new Integer(evento.getDia()));

        int i = db.update(TABELA_EVENTOS, //tabela
                values, // valores
                ID+" = ?", // colunas para comparar
                new String[] { String.valueOf(evento.getId()) }); //parâmetros
        db.close();
        return i; // número de linhas modificadas
    }

    public int deleteEvento(Evento evento) {
        SQLiteDatabase db = this.getWritableDatabase();

        int i = db.delete(TABELA_EVENTOS, //tabela
                ID+" = ?", // colunas para comparar
                new String[] { String.valueOf(evento.getId()) });

        db.close();
        return i; // número de linhas excluídas
    }
}
