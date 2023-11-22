package View;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.Clientes;

public class ClientesPainel extends JPanel {
    // Atributos
    // Campos de preenchimento
    private JTextField inputNome, inputEndereco, inputNumTel, inputCpf, inputDataNasc;
    private JButton cadastrar, excluir, editar, limpar;
    private List<Clientes> clientes;
    private JTable tableClien;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor
    public ClientesPainel() {

        // entrada de dados
        // Setando o layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro clientes"));

        JPanel inputPanelClien = new JPanel();

        // Implementando os componentes
        // NOME
        inputPanelClien.setLayout(new GridLayout(5, 2));
        inputNome = new JTextField(20);
        inputPanelClien.add(new JLabel("Nome"));
        inputPanelClien.add(inputNome);

        // CPF
        inputPanelClien.setLayout(new GridLayout(5, 2));
        inputCpf = new JTextField(20);
        inputPanelClien.add(new JLabel("CPF"));
        inputPanelClien.add(inputCpf);

        // DATA DE NASCIMENTO
        inputPanelClien.setLayout(new GridLayout(5, 2));
        inputDataNasc = new JTextField(20);

        inputPanelClien.add(new JLabel("Data Nascimento"));
        inputPanelClien.add(inputDataNasc);

        // NUMERO TELEFONE
        inputPanelClien.setLayout(new GridLayout(5, 2));
        inputNumTel = new JTextField(20);
        inputPanelClien.add(new JLabel("Telefone"));
        inputPanelClien.add(inputNumTel);

        // ENDEREÇO
        inputPanelClien.setLayout(new GridLayout(5, 2));
        inputEndereco = new JTextField(20);
        inputPanelClien.add(new JLabel("Endereço"));
        inputPanelClien.add(inputEndereco);
        add(inputPanelClien);

        // Criando um painel chamado botoes e add os componentes
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(excluir = new JButton("Apagar"));
        botoes.add(limpar = new JButton("Limpar"));
        add(botoes);

        // tabela de clientes
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);

        // Criação e desging da tabela
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Data Nascimento", "CPF", "Telefone", "Endereço" });
        tableClien = new JTable(tableModel);
        jSPane.setViewportView(tableClien);

        // Tratamento de eventos



    }

}
