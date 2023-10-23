import java.io.Serializable;

public class Agenda implements Serializable{
    private String usuario;
    private String data;
    private String hora;
    

    public Agenda(String usuario, String data, String hora) {
        this.usuario = usuario;
        this.data = data;
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }


    public String getHora() {
        return hora;
    }


    public void setHora(String hora) {
        this.hora = hora;
    }

    
}
