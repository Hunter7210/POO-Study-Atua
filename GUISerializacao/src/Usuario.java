import java.io.Serializable;

public class Usuario implements Serializable { //Classe do java onde a classe em que eu vou guardar os dados, sempre fazer implements nessa classe 
    private String nome;
    private int idade;

    //Construtor
    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    //Criação dos Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    

}
