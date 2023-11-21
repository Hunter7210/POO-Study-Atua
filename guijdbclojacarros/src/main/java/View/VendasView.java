package View;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Model.Carros;
import Model.Clientes;

public class VendasView extends JPanel {

    private JComboBox<String> carrosComboBox;
    private List<Carros> carros;
    private JButton enviar, limpar, historico;
    private JComboBox<String> clienteComboBox;
    private List<Clientes> clientes;

    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1; // Valor para quando não selecionar nada


    public VendasView() {
        super();

        JPanel painelPrinc = new JPanel();
        add(painelPrinc);

        // Listar carros cadastrados no JCombobox
        carrosComboBox = new JComboBox<>();
        // Listar clientes cadastrados no JCombobox
        clienteComboBox = new JComboBox<>();

        // Preencha o JComboBox com os campos
        // Carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecionar o carro");
        // Clientes
        clientes = new ClientesDAO().lisarClientes();
        clienteComboBox.addItem("Selecionar o cliente");
        
        //Preenche o comboBox 
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + "" + carro.getModelo() + "" + carro.getPlaca());
        }

        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + "" + carro.getModelo() + "" + carro.getPlaca());
        }

        //Adiciona os componentes
        painelPrinc.add(carrosComboBox);
        painelPrinc.add(clienteComboBox);

        //Criação de um painel para conter os botoes
        JPanel botoes = new JPanel();
        painelPrinc.add(botoes);
        enviar = new JButton("Comprar");
        historico = new JButton("Histórico");
        limpar = new JButton("Limpar");

        botoes.add(enviar);
        botoes.add(limpar);
        botoes.add(historico);

         // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);

        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Marca", "Modelo", "Ano", "Placa", "Valor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);
    }

}
