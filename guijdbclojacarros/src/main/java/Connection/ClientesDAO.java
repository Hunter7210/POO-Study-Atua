package Connection;

import java.util.ArrayList;
import java.util.List;

import Model.Clientes;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAO { // Responsável pela injeção de SQL
    // Atributos
    private Connection connection;
    private List<Clientes> clientes;

    // Construtor para conexão
    public ClientesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Metodo para Criação da tabela de conexão
    public void criarTabela() {
        String query = "CREATE TABLE IF NOT EXISTS clientes_lojacarros (nome VARCHAR(255), endereco VARCHAR(255), numTel VARCHAR(255), cpf VARCHAR(255) PRIMARY KEY, dataNasci VARCHAR(255))";

        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(query);
            System.out.println("Tabela criada com sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Lista de todos os valores cadastrados
    public List<Clientes> lisarClientes() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta

        clientes = new ArrayList<>();
        // Cria uma lista para armazenar os carros recuperados do banco de dados
        try {
            String query = "SELECT * FROM clientes_lojacarros";
            stmt = connection.prepareStatement(query);
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Carros com os valores do
                // registro
                Clientes cliente = new Clientes(
                        rs.getString("nome"),
                        rs.getString("Endereco"),
                        rs.getString("numTel"),
                        rs.getString("cpf"),
                        rs.getString("dataNasci"));
                clientes.add(cliente); // Add o objeto com todos os dados nele
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
            // Fecha os três
        }
        return clientes; // Retorna a lista para o banco de dados
    }

    //Cadastrar Clientes no banco de dados
    public void cadastrar(String ) {
        
    }

}
