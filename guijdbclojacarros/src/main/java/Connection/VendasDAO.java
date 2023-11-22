package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Carros;
import Model.Clientes;
import Model.Vendas;

public class VendasDAO {
    // atributos
    private Connection connection;
    private List<Vendas> vendas;

    // construtor contendo a conexão
    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Criação da tabela
    public void criarTabela() {
        String query = "CREATE TABLE IF NOT EXISTS vendas_lojacarros (dataVenda date, cliente VARCHAR(255) FOREIGN KEY REFERENCES clientes_lojacarros(cpf), carroVend VARCHAR(255) FOREIGN KEY REFERENCES carros_lojacarros, valorCompra VARCHAR(255), PRIMARY KEY(dataVenda));";

        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(query);
            System.out.println("Tabela criada com sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Metodo para listar os valores
    public List<Vendas> listarVendas() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta

        vendas = new ArrayList<>();
        // Cria uma lista para armazenar os carros recuperados do banco de dados
        try {
            String query = "SELECT * FROM vendas_lojacarros;";
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            stmt = connection.prepareStatement(query);
            // Resultado
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Carros com os valores do
                // registro
                Vendas venda = new Vendas(
                    rs.getString("dataVenda"),
                    rs.getString("carroVendi"),
                    rs.getString("cliente"),
                    rs.getString("valorCompra")
                );
                vendas.add(venda); // Add o objeto com todos os dados nele
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
            // Fecha os três
        }
        return vendas; // Retorna a lista para o banco de dados
    }

    //Cadastrar venda
    public void cadastrar(String dataVenda, String carroVendi, String cliente, String valorCompra) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String query = "INSERT INTO venda_lojacarros (dataVenda, cliente, carroVendi, valorCompra) VALUES (?, ?, ?, ?, ?)";

        try {
            // Preparando a consulta para a injeção
            stmt = connection.prepareStatement(query);
            stmt.setString(1, dataVenda);
            stmt.setString(2, cliente);
            stmt.setString(3, carroVendi);
            stmt.setString(4, valorCompra);

            // Executa a consulta
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
            // Fecha a conexão e o PreparedStatement
        }
    }


    // Inserir a criação de uma tabela, contendo Primary KEY e Foreign KEY para
    // buscar os dados dos nomes dos meus clientes (Usando a primary key de
    // clientes) e a Foreign KEY de Carros para buscar Nome do carro e valor da
    // compra (Usando a primary key de carros)

    // Não esqueça de criar o campo para inserção de data da venda, ou faça usando
    // alguma função do proprio java com base na hora do computador.

    // FALTA A DOCUMENTAÇÃO, BASICAMENTE UM MANUAL DE COMO USAR
}
