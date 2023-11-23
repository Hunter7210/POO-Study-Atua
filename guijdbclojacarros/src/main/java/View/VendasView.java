package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Connection.VendasDAO;
import Controler.VendasControl;
import Model.Carros;
import Model.Clientes;
import Model.Vendas;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.MouseEvent;

public class VendasView extends JPanel {

    private JComboBox<String> carrosComboBox;
    private List<Carros> carros;
    private JButton enviar, limpar;
    private List<Vendas> vendas;
    private JComboBox<String> clienteComboBox;
    private List<Clientes> clientes;

    private JTable tableVend;
    private DefaultTableModel tableModelVend;
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
                new String[] { "Data Venda", "Cliente", "Carro Vendido", "Valor" });
        tableVend = new JTable(tableModelVend);
        jSPane.setViewportView(tableVend);

        // Criar tabela vendas
        new VendasDAO().criarTabela();

        // Atualizar os dados da tabela
        atualizarTabela();

        /*
         * // Evento para pegar a linha selecionada atraves do Mouse
         * tableVend.addMouseListener(new MouseAdapter()){
         * 
         * @Override
         * public void (MouseEvent evt) {
         * linhaSelecionada = tableClien.rowAtPoint(evt.getPoint());
         * if (linhaSelecionada != -1) {
         * inputNome.setText((String) tableClien.getValueAt(linhaSelecionada, 0));
         * inputEndereco.setText((String) tableClien.getValueAt(linhaSelecionada, 1));
         * inputNumTel.setText((String) tableClien.getValueAt(linhaSelecionada, 2));
         * inputCpf.setText((String) tableClien.getValueAt(linhaSelecionada, 3));
         * inputDataNasc.setText((String) tableClien.getValueAt(linhaSelecionada, 4));
         * }
         * }
         * });
         */

        // Instanciando um obj da classe VendasConstrol

        VendasControl operacoesVend = new VendasControl(vendas, tableModelVend, tableVend);
        enviar.addActionListener(e -> {
            int carroSelec = carrosComboBox.getSelectedIndex();
            int clientSelec = clienteComboBox.getSelectedIndex();

            // Pegar data e hora atual do computador
            Date dataEHora = new Date();
            String data = new SimpleDateFormat("dd/mm/aaaa").format(dataEHora);
            String hora = new SimpleDateFormat("HH:mm:ss").format(dataEHora);

            String horario = data + "\n" + hora;

            operacoesVend.cadastrar(horario, carrosComboBox.getItemAt(clientSelec) ,carrosComboBox.getItemAt(clientSelec) , carrosComboBox.getItemAt(clientSelec));

            System.out.println(horario);

        });
        // Tratameno de eventos

        // Criar um VendasDAO para armazenar as funções para meus botoes,
        // Enviar= Inserir ao banco de dados e ao mesmo tempo excluir o carro comprado,
        // mas manter no historico
        // Histórico = Mostrar todos os dados já inseridos dos carros
        // Limpar= limpar os campos, voltar o default. Exemplo: Os comboBoxs voltarem
        // para a primeria linha

    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModelVend.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarVendas();
        // Obtém os carros atualizados do banco de dados
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModelVend.addRow(new Object[] { venda.getDataVenda(), venda.getCliente(), venda.getCarroVendi(),
                    venda.getValorCompra() });
        }
    }

}
