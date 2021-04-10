package fragmento.cursoandroid.com.divulgaae1;

/**
 * Created by Valdson on 03/03/2018.
 */
public class Evento {
    private  int id;
    private String nome;
    private String endereco;
    private int dia; // vai armazenar o identificador do recurso

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
