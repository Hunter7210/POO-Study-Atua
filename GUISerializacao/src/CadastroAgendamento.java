import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import java.io.File;

import java.awt.CardLayout;
import java.awt.BorderLayout;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CadastroAgendamento extends JPanel {
    // Atributos
    private JTextField inputData;
    private JTextField inputHora;
    private JTextField inputDescricao;
    private JComboBox<String> comboUsuario; // Determina como a tabela vai ser construída
    private DefaultTableModel tableModel;
    private JTable table; // Serve para mostrar a tabela.
    public List<Agenda> agendamento = new ArrayList<>();
    private int linhaSelecionada = -1;

    /**
     * 
     */
    public CadastroAgendamento() {
 // Preencher a tabela
    File arquivo = new File("dados.txt");
    List<Usuario> usuarios = new ArrayList<>();

    if (arquivo.exists()) {
        usuarios = Serializacao.deserializar("dados.txt");
        }
        // Configurações do JFrame
        setSize(800, 600);
        this.setVisible(true);

        // Formato da minha tabela, parte lógica
        tableModel = new DefaultTableModel(); // Definindo um obj
        tableModel.addColumn("Data"); // Add uma coluna a esse obj, ou seja add ao tablemodel
        tableModel.addColumn("Hora");
        tableModel.addColumn("Usuario");
        tableModel.addColumn("Descrição");

        // Formato da minha tabela, parte gráfica
        table = new JTable(tableModel); // Criação de um obj de JTABLE baseado na tablemodel
        JScrollPane scrollPane = new JScrollPane(table); // Scrollbar

        inputData = new JTextField(8);
        inputHora = new JTextField(8);
        inputDescricao = new JTextField(8);

        //Add combobox
        comboUsuario = new JComboBox<>();

        for (Usuario usuario : usuarios) {
            comboUsuario.addItem(usuario.getNome());
        }

        JButton cadastroAgendaButton = new JButton("Cadastrar");
        JButton atualizarAgendaButton = new JButton("Atualizar");
        JButton apagarAgendaButton = new JButton("Apagar");
        JButton salvarAgendaButton = new JButton("Salvar");
        JButton trocarButton = new JButton("Agende Aqui!");


        JPanel inputAgendaPanel = new JPanel();
        inputAgendaPanel.add(new JLabel("Data: "));
        inputAgendaPanel.add(inputData);
        inputAgendaPanel.add(new JLabel("Hora: "));
        inputAgendaPanel.add(inputHora);
        inputAgendaPanel.add(new JLabel("Usuario: "));
        inputAgendaPanel.add(comboUsuario);
        inputAgendaPanel.add(new JLabel("Descrição: "));
        inputAgendaPanel.add(inputDescricao);
        inputAgendaPanel.add(cadastroAgendaButton);
        inputAgendaPanel.add(atualizarAgendaButton);
        inputAgendaPanel.add(apagarAgendaButton);
        inputAgendaPanel.add(salvarAgendaButton);

        // Add ao Layout
        setLayout(new BorderLayout());
        add(inputAgendaPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(trocarButton, BorderLayout.SOUTH);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint()); //PEGA O PONTO ONDE EU CLIQUEI
                if (linhaSelecionada != -1) {
                    inputData.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputHora.setText(table.getValueAt(linhaSelecionada, 1).toString());
                    /* comboUsuario.(table.getValueAt(linhaSelecionada, 2).toString()); */
                    inputDescricao.setText(table.getValueAt(linhaSelecionada, 3).toString());

                }
            }
        });

        OperacoesUsuarios operacoes = new OperacoesUsuarios(usuarios, tableModel, table);

        cadastroAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadas(inputData.getText(), inputHora.getText(), inputDescricao.getText());
                inputData.setText("");
                inputDescricao.setText("");
                inputHora.setText("");
            }
        });

        atualizarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarUsuario(linhaSelecionada, inputData.getText(),
                inputHora.getText());
            }
        });

        apagarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarUsuario(linhaSelecionada);
            }
        });

        salvarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarUsuarios();
            }
        });
    }
}

