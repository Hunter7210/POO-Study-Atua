package View;

import java.util.List;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import Controler.CarrosConstrol;
import Controler.LimitaCaracteres;
import Model.Carros;

public class CarrosPainel extends JPanel {

    // Atributos
    private JButton cadastrar, apagar, editar, limpar;
    private JTextField carMarcaField, carModeloField, carAnoField, carPlacaField, carValorField;
    private List<Carros> carros;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1; // Valor para quando não selecionar nada

    // Construtor

    public CarrosPainel() {
        super();

        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Carros"));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Marca"));

        carMarcaField = new JTextField(20);
        inputPanel.add(carMarcaField);
        inputPanel.add(new JLabel("Modelo"));

        carModeloField = new JTextField(20);

        inputPanel.add(carModeloField);
        inputPanel.add(new JLabel("Ano"));

        carAnoField = new JTextField(20);
        inputPanel.add(carAnoField);

        inputPanel.add(new JLabel("Placa"));

        carPlacaField = new JTextField(20);

        inputPanel.add(carPlacaField);
        inputPanel.add(new JLabel("Valor"));

        carValorField = new JTextField(20);

        inputPanel.add(carValorField);
        add(inputPanel);

        // Criando um painel chamado botoes e add os componentes
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        botoes.add(limpar = new JButton("Limpar"));
        add(botoes);

        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);

        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Marca", "Modelo", "Ano", "Placa", "Valor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Atribuindo o limitador de caracteres a cada um dos meus Inputs com os
        // paramêtros de qtdCaracteres e o TipoEntrada
        carMarcaField.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.MARCA));
        carModeloField.setDocument(new LimitaCaracteres(30, LimitaCaracteres.TipoEntrada.MODELO));
        carAnoField.setDocument(new LimitaCaracteres(4, LimitaCaracteres.TipoEntrada.ANO));
        carPlacaField.setDocument(new LimitaCaracteres(8, LimitaCaracteres.TipoEntrada.PLACA));
        carValorField.setDocument(new LimitaCaracteres(20, LimitaCaracteres.TipoEntrada.VALOR));

        // Cria o banco de dados caso não tenha sido criado
        new CarrosDAO().criaTabela();


        // incluindo elementos do banco na criação do painel
        atualizarTabela();
        
        // tratamento de Eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    carMarcaField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    carModeloField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    carAnoField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    carPlacaField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    carValorField.setText((String) table.getValueAt(linhaSelecionada, 4));
                }
            }
        });
        // Cria um objeto operacoes da classe CarrosControl para executar operações no
        // banco
        CarrosConstrol operacoes = new CarrosConstrol(carros, tableModel, table);

        // Configura a ação do botão "cadastrar" para adicionar um novo registro no
        // banco de dados
        // Tratamento de eventos
        cadastrar.addActionListener(e -> {
            // Verifica se todos os campos estão preenchidos
            if (!carMarcaField.getText().isEmpty() && !carModeloField.getText().isEmpty()
                    && !carAnoField.getText().isEmpty()
                    && !carPlacaField.getText().isEmpty() && !carValorField.getText().isEmpty()) {

                // Pergunta se o usuario quer realmente se cadastrar
                int podCadast = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cadastrar o carro?",
                        "Escolha uma opção", JOptionPane.YES_NO_OPTION);
                // Verifica se a escolha foi YES
                if (podCadast == JOptionPane.YES_OPTION) {

                    operacoes.cadastrar(carMarcaField.getText(), carModeloField.getText(), carAnoField.getText(),
                            carPlacaField.getText(), carValorField.getText());
                    // Limpa os campos de entrada após a operação de cadastro
                    carMarcaField.setText("");
                    carModeloField.setText("");
                    carAnoField.setText("");
                    carPlacaField.setText("");
                    carValorField.setText("");
                    // Retorna ao usuario que foi cadastrado
                    JOptionPane.showMessageDialog(this, "Carro cadastrado com sucesso!");
                } else {
                    // Se a escolha for != de YES
                    // Busca uma segunda confirmação
                    int desejReturn = JOptionPane.showConfirmDialog(this, "Deseja retornar ao cadastro?",
                            "Escolha uma opção", JOptionPane.YES_NO_OPTION);
                    if (desejReturn == JOptionPane.YES_OPTION) {
                        // Fecha o JOptionPane automaticamente

                    } else {
                        carMarcaField.setText("");
                        carModeloField.setText("");
                        carAnoField.setText("");
                        carPlacaField.setText("");
                        carValorField.setText("");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
            }
        });

        // Configura a ação do botão "editar" para atualizar um registro no banco de
        // dados
        editar.addActionListener(e -> {
            if (linhaSelecionada != -1) {

                if (!carMarcaField.getText().isEmpty() && carAnoField.getText().isEmpty()
                        && !carModeloField.getText().isEmpty() && !carPlacaField.getText().isEmpty()
                        && !carValorField.getText().isEmpty()) {

                    // Confirmação se deseja realmente atualizar os dados
                    int podAtualizar = JOptionPane.showConfirmDialog(editar, "Deseja realmente atualizar os dados",
                            "Escolha uma opção: ", JOptionPane.YES_NO_OPTION);
                    if (podAtualizar == JOptionPane.YES_OPTION) {
                        // Chama o método "atualizar" do objeto operacoes com os valores dos campos de
                        // entrada
                        // Transforma os dados de anoDigitado em Inteiro
                        int anoDigitado = Integer.parseInt(carAnoField.getText());
                        // Compara se o ano está entre 1920 && 2024

                        if (anoDigitado > 1920 && anoDigitado < 2024) {
                            operacoes.atualizar(carMarcaField.getText(), carModeloField.getText(),
                                    carAnoField.getText(), carPlacaField.getText(), carValorField.getText());
                            // Limpa os campos de entrada após a operação de atualização
                            carMarcaField.setText("");
                            carModeloField.setText("");
                            carAnoField.setText("");
                            carPlacaField.setText("");
                            carValorField.setText("");

                            // Retorna ao usuario uma confirmação
                            JOptionPane.showMessageDialog(editar, "Dados atualizados com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "DATA INVALÍDA\nDigite uma data válida (1920 até 2024)");
                        }
                    } else {
                        JOptionPane.showMessageDialog(editar,
                                "Infelizmente, não foi possivel cadastrar seus dados!\nPor favor, verifique se os dados estão corretos!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Necessário selecionar um dado abaixo.");
            }
        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(e -> {
            if (!carMarcaField.getText().isEmpty() && !carAnoField.getText().isEmpty()
                    && !carModeloField.getText().isEmpty() && !carPlacaField.getText().isEmpty()
                    && !carValorField.getText().isEmpty()) {

                int desejApag = JOptionPane.showConfirmDialog(apagar, "Deseja realmente deletar estes dados?",
                        "Escolha uma opção: ", JOptionPane.YES_NO_OPTION);

                if (desejApag == JOptionPane.YES_OPTION) {

                    // Chama o método "apagar" do objeto operacoes com o valor do campo de entrada
                    // "placa"
                    operacoes.apagar(carPlacaField.getText());
                    // Limpa os campos de entrada após a operação de exclusão
                    carMarcaField.setText("");
                    carModeloField.setText("");
                    carAnoField.setText("");
                    carPlacaField.setText("");
                    carValorField.setText("");

                    JOptionPane.showMessageDialog(apagar, "Dados apagados com sucesso!");
                } else {
                    // Se a escolha for <> de YES
                    // Busca uma segunda confirmação
                    int desejReturn = JOptionPane.showConfirmDialog(cadastrar, "Deseja retornar ao cadastro?",
                            "Escolha uma opção", JOptionPane.YES_NO_OPTION);
                    if (desejReturn == JOptionPane.YES_OPTION) {
                        // Fecha somente o JOptionPane

                    } else {
                        // Limpa todos os campos
                        carMarcaField.setText("");
                        carModeloField.setText("");
                        carAnoField.setText("");
                        carPlacaField.setText("");
                        carValorField.setText("");
                        // Fecha somente o JOptionPane
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Necessário selecionar um dado abaixo.");
            }
        });

        limpar.addActionListener(e -> {
            if (!carMarcaField.getText().isEmpty() || !carAnoField.getText().isEmpty()
                    || !carModeloField.getText().isEmpty() || !carPlacaField.getText().isEmpty()
                    || !carValorField.getText().isEmpty()) {

                int desejLimp = JOptionPane.showConfirmDialog(this, "Deseja realmente limpar os dados nos campos?",
                        "Escolha uma opção: ", JOptionPane.YES_NO_OPTION);
                if (desejLimp == JOptionPane.YES_OPTION) {
                    linhaSelecionada = -1;

                    // Limpa todos os campos
                    carMarcaField.setText("");
                    carModeloField.setText("");
                    carAnoField.setText("");
                    carPlacaField.setText("");
                    carValorField.setText("");
                    atualizarTabela();
                    // Retorna esta mensagem ao usario
                    JOptionPane.showMessageDialog(this, "Campos limpos com sucesso!");

                } else {
                    // Fecha somente o JOptionPane
                }
            } else {
                JOptionPane.showMessageDialog(this, "Necessário preencher algum campo.");

            }

        });
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        carros = new CarrosDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Carros carro : carros) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { carro.getMarca(), carro.getModelo(),
                    carro.getAno(), carro.getPlaca(), carro.getValor() });
        }
    }
}