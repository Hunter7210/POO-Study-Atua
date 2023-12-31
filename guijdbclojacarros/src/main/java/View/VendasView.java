package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Connection.VendasDAO;
import Controler.VendasControl;
import Model.Carros;
import Model.Clientes;
import Model.Vendas;

public class VendasView extends JPanel {

    private JComboBox<String> carrosComboBox;
    private List<Carros> carros;
    private JButton enviar, limpar;
    private List<Vendas> vendas;
    private JComboBox<String> clienteComboBox;
    private List<Clientes> clientes;

    private JTable tableVend;
    private DefaultTableModel tableModelVend;

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
        clientes = new ClientesDAO().listarClientes();
        clienteComboBox.addItem("Selecionar o cliente");

        // Preenche o comboBox
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + " " + carro.getModelo() + " " + carro.getPlaca());
        }

        for (Clientes cliente : clientes) {
            clienteComboBox.addItem(cliente.getNome() + " " + cliente.getCpf());
        }

        // Adiciona os componentes
        painelPrinc.add(carrosComboBox);
        painelPrinc.add(clienteComboBox);

        // Criação de um painel para conter os botoes
        JPanel botoes = new JPanel();
        enviar = new JButton("Cadastrar Venda");

        limpar = new JButton("Limpar");
        painelPrinc.add(botoes);

        botoes.add(enviar);
        botoes.add(limpar);

        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);

        tableModelVend = new DefaultTableModel(new Object[][] {},
                new String[] { "Data Venda", "Carro Vendido", "Cliente" });
        tableVend = new JTable(tableModelVend);
        jSPane.setViewportView(tableVend);

        // Criar tabela vendas
        new VendasDAO().criarTabela();

        // Atualizar os dados da tabela
        atualizarTabela();

        // Instanciando um obj da classe VendasConstrol
        VendasControl operacoesVend = new VendasControl(vendas, tableModelVend, tableVend);
        // Buscando o item selecionado no comboBox

        // Ao clicar no botao enviar executa:
        enviar.addActionListener(e -> {

            Object carroSelecObj = carrosComboBox.getSelectedItem();
            Object clienteSelecObj = clienteComboBox.getSelectedItem();

            int carroSelecInt = carrosComboBox.getSelectedIndex();
            int clienteSelecInt = clienteComboBox.getSelectedIndex();

            if (carroSelecInt != 0 || clienteSelecInt != 0) {

                // Pegar data e hora atual do computador
                Date dataEHora = new Date();
                // Formatando
                String data = new SimpleDateFormat("dd/mm").format(dataEHora);
                String hora = new SimpleDateFormat("HH:mm:ss aaaa").format(dataEHora);
                String horario = data + " " + hora;

                // Transformando o item para String
                String carroSelecStr = carroSelecObj.toString();
                String clienteSelecStr = clienteSelecObj.toString();

                operacoesVend.cadastrar(horario, carroSelecStr, clienteSelecStr);

                carrosComboBox.setSelectedIndex(0);
                clienteComboBox.setSelectedIndex(0);

            } else {
                JOptionPane.showMessageDialog(this,
                        "Por favor, escolha um carro e um cliente!");
            }

        });

        // Criando um evento para resetar os dados selecionados
        limpar.addActionListener(e -> {
            Object carroSelecObj = carrosComboBox.getSelectedItem();
            Object clienteSelecObj = clienteComboBox.getSelectedItem();

            // Retona ao index inicial
            if (!carroSelecObj.equals("Selecionar o carro") || !clienteSelecObj.equals("Selecionar o cliente")) {
                // Chama o metodo limparCombo, com os seus parametros
                limparCombo(carroSelecObj, clienteSelecObj);
                JOptionPane.showMessageDialog(this, "Campos limpos com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Necessário preencher algum campo!");
            }

        });

    }

    private void limparCombo(Object combo1, Object combo2) {
        carrosComboBox.setSelectedIndex(0);
        clienteComboBox.setSelectedIndex(0);
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModelVend.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarVendas();
        // Obtém as vendas atualizados do banco de dados
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada venda como uma nova linha na tabela Swing
            tableModelVend.addRow(new Object[] { venda.getDataVenda(), venda.getCliente(), venda.getCarroVendi(),
                    venda.getValorCompra() });
        }
    }
}
