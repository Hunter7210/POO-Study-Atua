package Model;

public class Clientes {
    //Atributos
    public String nome;
    public String endereco;
    public String num_tel;
    public String cpf;
    public String data_nasc;

    public Clientes(String nome, String endereco, String num_tel, String cpf, String data_nascString) {

        this.nome = nome;
        this.endereco = endereco;
        this.num_tel = num_tel;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
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

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    //Getters and setters

    
}
