import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TodoList extends JFrame { // Extends significa fazer uma subclasse de JFrame

    // ATRIBUTOS
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;

    // Componenetes novos
    // Ambas são da classe swing, ou seja, é focado para criação de tabelas.
    // Basicamente ela pega as listas que existem no meu sistema e a colocam de uma
    // forma grafica
    private JList<String> taskList; // JList é uma lista grafica, no caso pega so elementos da classe Task lá em
                                    // baixo
    private DefaultListModel<String> listModel;

    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;

    private List<Task> tasks;// Interface de Arraylist, não é possível instanciar deve ser usado o Arraylist

    // Construtor
    public TodoList() {
        // Configuração da janela principal
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 400);

        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>(); // Task é o nome da minha list, não é possível instanciar objeots da classe list
        listModel = new DefaultListModel<>(); // Seta os modelos
        taskList = new JList<>(listModel);

        // Inicializa campos de entrada, botões e JComboBox
        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");

        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);// ScrollPane, é baseada na taskList
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        this.add(mainPanel);

        Handler hand = new Handler();

        // TRATAMENTO DE EVENTOS
        addButton.addActionListener(e -> {
            addKeyListener(hand);

        });
        deleteButton.addActionListener(e -> {
            deleteTask();

        });
        markDoneButton.addActionListener(e -> {
            markTaskDone();

        });
        filterComboBox.addActionListener(e -> {
            filterTasks();

        });
        clearCompletedButton.addActionListener(e -> {
            clearCompletedTasks();

        });

        taskList.addMouseListener(hand);
        taskInputField.addKeyListener(hand);
        /* addButton.addKeyListener(hand); */

    }

    /**
     * Handler
     */
    public class Handler implements MouseListener, MouseMotionListener, KeyListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            /* listModel(tasks).setVisible(false); */

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) { // Click

            if (e.getClickCount() == 2) {
                int index = taskList.getSelectedIndex();
                if (index >= 0 && index < tasks.size()) {
                    Task task = tasks.get(index); // Pegou o elemento do arraylist
                    task.setDone(true); // Usando o Setters do outro metodo
                    if (task.isDone() == true) {

                        /* taskList.setSelectionBackground(Color.GREEN); */
                        markTaskDone();

                    } else {
                        taskList.setSelectionBackground(Color.red);
                    }
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) { // ESTA EM CIMA

        }

        @Override
        public void mouseExited(MouseEvent e) { // não tem nada

        }

        @Override
        public void mousePressed(MouseEvent e) { // Pressionado

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // TECLADO
        // Adionar uma tarefa apertando a tecla ENTER
        @Override
        public void keyPressed(KeyEvent e) {
            // if para comparar se o que foi digitado é igual a tecla Enter
            if (e.getKeyCode() == KeyEvent.VK_ENTER) { // VK.ENTER é o codigo para a tecla enter
                // Perguntar se deseja adcionar
                int funciona; // Variavel criada para receber valor do JOptionPane
                funciona = JOptionPane.showConfirmDialog(null, "Deseja realmente adicionar tarefa:");

                if (funciona == JOptionPane.YES_OPTION) {
                    addTask();
                } else {
                    taskInputField.setText("");
                }

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

    }

    // MÉTODOS
    // Tornar

    // CREATE, C DO CRUD
    private void addTask() {
        // Adiciona uma nova task à lista de tasks
        String taskDescription = taskInputField.getText().trim();// TRIM = remove espaços vazios
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();// Chama o outro metodo
            taskInputField.setText("");
        }
    }

    // DELETE, R DO CRUD

    private void deleteTask() {
        // Exclui a task selecionada da lista de tasks
        int selectedIndex = taskList.getSelectedIndex(); // Pega o index da tarefa que esta selecionado
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) { // Vê se ela existe
            tasks.remove(selectedIndex); // tasks é o meu Arraylist
            updateTaskList(); // Atualiza o Scroll

        }
    }

    // UPDATE, U do CRUD
    private void markTaskDone() {
        // Marca a task selecionada como concluída
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex); // Pegou o elemento do arraylist
            task.setDone(true); // Usando o Setters do outro metodo

            updateTaskList(); // Atualiza a tasklist

        }
    }

    // READ, R do CRUD
    private void filterTasks() {
        // Filtra as tasks com base na seleção do JComboBox
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        // FOREACH percorre o meu Arraylist
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") &&
                    !task.isDone()) || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription());
            }
        }
    }

    private void clearCompletedTasks() {
        // Limpa todas as tasks concluídas da lista
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        tasks.removeAll(completedTasks);
        updateTaskList();
    }

    private void updateTaskList() {
        // Atualiza a lista de tasks exibida na GUI
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : "")); // listModel é a lista
                                                                                                 // simplificada chamado
                                                                                                 // ternário

        }
    }

    public void run() {
        this.setVisible(true);
    }

}
