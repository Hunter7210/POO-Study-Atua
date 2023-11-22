package Connection;

import java.sql.Connection;
import java.util.List;

import Model.Carros;
import Model.Vendas;

public class VendasDAO {
    // atributos
    private Connection connection;
    private List<Vendas> vendas;

    // construtor contendo a conexão
    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    //Inserir a criação de uma tabela, contendo Primary KEY e Foreign KEY para buscar os dados dos nomes dos meus clientes (Usando a primary key de clientes) e a Foreign KEY de Carros para buscar Nome do carro e valor da compra (Usando a primary key de carros)

    //Não esqueça de criar o campo para inserção de data da venda, ou faça usando alguma função do proprio java com base na hora do computador.


    //FALTA A DOCUMENTAÇÃO, BASICAMENTE UM MANUAL DE COMO USAR
}
