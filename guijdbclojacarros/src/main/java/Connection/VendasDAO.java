package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        String query = "CREATE TABLE IF NOT EXISTS vendas_lojacarros (datavenda varchar(255), cliente VARCHAR(255), carroVend VARCHAR(255), valorCompra VARCHAR(255), PRIMARY KEY(dataVenda), FOREIGN KEY (valorCompra) REFERENCES carros_lojacarros (placa));";

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
                        rs.getString("datavenda"),
                        rs.getString("carroVend"),
                        rs.getString("cliente"),
                        rs.getString("valorCompra"));
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

    // Cadastrar venda
    public void cadastrar(String dataVenda, String carroVendi, String cliente) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String query = "INSERT INTO vendas_lojacarros (datavenda, carroVend, cliente) VALUES (?, ?, ?)";

        try {
            // Preparando a consulta para a injeção
            stmt = connection.prepareStatement(query);
            stmt.setString(1, dataVenda);
            stmt.setString(2, carroVendi);
            stmt.setString(3, cliente);
            

            // Executa a consulta
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir dados no banco", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
            // Fecha a conexão e o PreparedStatement
        }
    }

}
