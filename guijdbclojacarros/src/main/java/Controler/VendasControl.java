package Controler;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.VendasDAO;
import Model.Vendas;

public class VendasControl { // Filtro de informações

    // Atributos
    private List<Vendas> vendas;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
        this.vendas = vendas;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Metodo para atualizar a tabela com os dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas da tabela
        vendas = new VendasDAO().listarVendas();
        // Pega as vendas realizadas
        for (Vendas venda : vendas) {
            // Adiciona os dados a cadas venda no java swing
            tableModel.addRow(new Object[] {venda.getDataVenda(),venda.getCarroVendi(), venda.getCliente(), venda.getValorCompra()});
        }
    }

    // Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String dataVenda, String carroVendi, String cliente) {
        new VendasDAO().cadastrar(dataVenda, carroVendi, cliente);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

}
