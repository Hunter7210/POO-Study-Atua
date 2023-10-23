import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;

public class Cadastro extends JFrame {
    // Atributos
    private JPanel painelMain;
    private JPanel painelCadastro;
    private JPanel painelAgenda;
    private JTextField inputNome;
    private JTextField inputIdade;
    private DefaultTableModel tableModel; // Determina como a tabela vai ser construída
    private JTable table; // Serve para mostrar a tabela.
    private List<Usuario> usuarios = new ArrayList<>();
    private int linhaSelecionada = -1;

    // Construtor
    public Cadastro() {
        // Configurações do JFrame
        setTitle("Cadastro de Usuários");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setVisible(true);

        painelMain = new JPanel();
        this.add(painelMain);

        painelCadastro = new JPanel();
        painelAgenda = new JPanel();

        painelMain.setLayout(new CardLayout());
        painelMain.add(painelCadastro, "Cadastro");
        painelMain.add(painelAgenda, "Agenda");

        // Formato da minha tabela, parte lógica
        tableModel = new DefaultTableModel(); // Definindo um obj
        tableModel.addColumn("Nome"); // Add uma coluna a esse obj, ou seja add ao tablemodel
        tableModel.addColumn("Idade");

        // Formato da minha tabela, parte gráfica
        table = new JTable(tableModel); // Criação de um obj de JTABLE baseado na tablemodel
        JScrollPane scrollPane = new JScrollPane(table); // Scrollbar
        
        inputNome = new JTextField(20);
        inputIdade = new JTextField(5);

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton apagarTodosButton = new JButton("Apagar todos");
        JButton salvarButton = new JButton("Salvar");
        JButton trocarButton = new JButton("Agende Aqui!");

        JPanel inputPanel = new JPanel();  
        inputPanel.add(new JLabel("Nome: "));
        inputPanel.add(inputNome);
        inputPanel.add(new JLabel("Idade: "));
        inputPanel.add(inputIdade);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(apagarTodosButton);
        inputPanel.add(salvarButton);

        
        // Add ao Layout
        painelCadastro.setLayout(new BorderLayout());
        painelCadastro.add(inputPanel, BorderLayout.NORTH);
        painelCadastro.add(scrollPane, BorderLayout.CENTER);
        painelCadastro.add(trocarButton, BorderLayout.SOUTH);



























        
        // Preencher a tabela
        File arquivo = new File("dados.txt");
        if (arquivo.exists()) {
            usuarios = Serializacao.deserializar("dados.txt");
            atualizarTabela();
        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputNome.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputIdade.setText(table.getValueAt(linhaSelecionada, 1).toString());
                }
            }
        });
        OperacoesUsuarios operacoes = new OperacoesUsuarios(usuarios, tableModel, table);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrarUsuario(inputNome.getText(), inputIdade.getText());
                inputNome.setText("");
                inputIdade.setText("");
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarUsuario(linhaSelecionada, inputNome.getText(),
                inputIdade.getText());
            }
        });

        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarUsuario(linhaSelecionada);
            }
        });
        apagarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarTodosUsuarios();
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarUsuarios();
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() });
        }
    }
}
