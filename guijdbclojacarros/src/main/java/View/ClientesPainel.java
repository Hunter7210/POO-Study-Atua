package View;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Controler.ClientesConstrol;
import Model.Carros;
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


        //Atualiza a tabela
        atualizarTabela();

        //Cria um obj da classe ClientesConstrol
        ClientesConstrol operacoes = new ClientesConstrol(clientes, tableModel, tableClien);

        // Tratamento de eventos
        cadastrar.addActionListener(e -> {
            // Verifica se todos os campos estão preenchidos
            if (!inputNome.getText().isEmpty() || !inputEndereco.getText().isEmpty()
                    || !inputNumTel.getText().isEmpty() || !inputCpf.getText().isEmpty()
                    || !inputDataNasc.getText().isEmpty()) {

                // Pergunta se o usuario quer realmente se cadastrar
                int podCadast = JOptionPane.showConfirmDialog(cadastrar, "Tem certeza que deseja cadastrar o cliente?",
                        "Escolha uma opção", JOptionPane.YES_NO_OPTION);
                // Verifica se a escolha foi YES
                if (podCadast == JOptionPane.YES_OPTION) {
                    operacoes.cadastrar(inputNome.getText(), inputEndereco.getText(),
                            inputNumTel.getText(), inputCpf.getText(), inputDataNasc.getText());
                    // Limpa os campos de entrada após a operação de cadastro
                    inputNome.setText("");
                    inputEndereco.setText("");
                    inputNumTel.setText("");
                    inputCpf.setText("");
                    inputDataNasc.setText("");
                    JOptionPane.showMessageDialog(editar, "Carro cadastrado com sucesso!");
                } else {
                    // Se a escolha for != de YES
                    // Busca uma segunda confirmação
                    int desejReturn = JOptionPane.showConfirmDialog(cadastrar, "Deseja retornar ao cadastro?",
                            "Escolha uma opção", JOptionPane.YES_NO_OPTION);
                    if (desejReturn == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    } else {
                        inputNome.setText("");
                        inputEndereco.setText("");
                        inputNumTel.setText("");
                        inputCpf.setText("");
                        inputDataNasc.setText("");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(cadastrar, "Por favor, preencha todos os campos.");
            }
        });

        // Configura a ação do botão "editar" para atualizar um registro no banco de
        // dados
        editar.addActionListener(e -> {
            // Confirmação se deseja realmente atualizar os dados
            int podAtualizar = JOptionPane.showConfirmDialog(editar, "Deseja realmente atualizar os dados do cliente?",
                    "Escolha uma opção: ", JOptionPane.YES_NO_OPTION);
            if (podAtualizar == JOptionPane.YES_OPTION) {
                // Chama o método "atualizar" do objeto operacoes com os valores dos campos de
                // entrada
                operacoes.atualizar(inputNome.getText(), inputEndereco.getText(),
                        inputNumTel.getText(), inputCpf.getText(), inputDataNasc.getText());
                // Limpa os campos de entrada após a operação de atualização
                inputNome.setText("");
                inputEndereco.setText("");
                inputNumTel.setText("");
                inputCpf.setText("");
                inputDataNasc.setText("");

                // Retorna ao usuario uma confirmação
                JOptionPane.showMessageDialog(editar, "Dados atualizados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(editar,
                        "Infelizmente, não foi possivel cadastrar seus dados!\nPor favor, verifique se os dados estão corretos!");
                System.exit(0);
            }
        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        excluir.addActionListener(e -> {
            int desejApag = JOptionPane.showConfirmDialog(excluir, "Deseja realmente deletar estes dados?",
                    "Escolha uma opção: ", JOptionPane.YES_NO_OPTION);

            if (desejApag == JOptionPane.YES_OPTION) {
                // Chama o método "apagar" do objeto operacoes com o valor do campo de entrada
                // "placa"
                operacoes.apagar(inputCpf.getText());
                // Limpa os campos de entrada após a operação de exclusão
                inputNome.setText("");
                inputEndereco.setText("");
                inputNumTel.setText("");
                inputCpf.setText("");
                inputDataNasc.setText("");

                JOptionPane.showMessageDialog(excluir, "Dados apagados com sucesso!");

            } else {
                // Se a escolha for != de YES
                // Busca uma segunda confirmação
                int desejReturn = JOptionPane.showConfirmDialog(cadastrar, "Deseja retomar o cadastro?",
                        "Escolha uma opção", JOptionPane.YES_NO_OPTION);
                if (desejReturn == JOptionPane.YES_OPTION) {
                    // Fecha somente o JOptionPane
                    System.exit(0);
                } else {
                    // Limpa todos os campos
                    inputNome.setText("");
                    inputEndereco.setText("");
                    inputNumTel.setText("");
                    inputCpf.setText("");
                    inputDataNasc.setText("");
                    // Fecha somente o JOptionPane
                    System.exit(0);
                }
            }
        });

        limpar.addActionListener(e -> {
            int desejLimp = JOptionPane.showConfirmDialog(limpar, "Deseja realmente limpar os dados dos campos?",
                    "Escolha uma opção: ", JOptionPane.YES_NO_OPTION);
            if (desejLimp == JOptionPane.YES_OPTION) {
                // Limpa todos os campos
                inputNome.setText("");
                inputEndereco.setText("");
                inputNumTel.setText("");
                inputCpf.setText("");
                inputDataNasc.setText("");
                // Fecha somente o JOptionPane
                System.exit(0);

                JOptionPane.showMessageDialog(limpar, "Campos limpos com sucesso!");
            } else {
                // Fecha somente o JOptionPane
                System.exit(0);
            }
        });
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientes = new ClientesDAO().listarClientes();
        // Obtém os carros atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEndereco(), cliente.getCpf(),
                    cliente.getDataNasc(), cliente.getNumTel() });
        }
    }
}
