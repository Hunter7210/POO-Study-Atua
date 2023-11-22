package View;

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

    private JTable tableClient;
    private DefaultTableModel tableModelClient;
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
        
        //Preenche o comboBox 
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + "\t" + carro.getModelo() + "\t" + carro.getPlaca());
        }

        for (Clientes cliente : clientes) {
            clienteComboBox.addItem(cliente.getNome() + "\t" + cliente.getCpf());
        }

        //Adiciona os componentes
        painelPrinc.add(carrosComboBox);
        painelPrinc.add(clienteComboBox);

        //Criação de um painel para conter os botoes
        JPanel botoes = new JPanel();
        enviar = new JButton("Comprar");
        historico = new JButton("Histórico");
        limpar = new JButton("Limpar");
        painelPrinc.add(botoes);

        botoes.add(enviar);
        botoes.add(limpar);
        botoes.add(historico);

         // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);

        tableModelClient = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Data Nascimento", "CPF", "Telefone", "Endereço" });
        tableClient = new JTable(tableModelClient);
        jSPane.setViewportView(tableClient);



        //Tratameno de eventos 


        //Criar um VendasDAO para armazenar as funções para meus botoes,
        //Enviar= Inserir ao banco de dados e ao mesmo tempo excluir o carro comprado, mas manter no historico
        //Histórico = Mostrar todos os dados já inseridos dos carros
        //Limpar= limpar os campos, voltar o default. Exemplo: Os comboBoxs voltarem para a primeria linha  

    }




}
