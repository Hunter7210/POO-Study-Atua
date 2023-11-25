package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JanelaPrincipal extends JFrame {
    // Construtor
    // criação do tabbedPane para incluir as tabs
    private JPanel painelPrinc, painelLate, painelCard, painelComponen;
    private JLabel titulo, carros, clientes, vendas;

    public JanelaPrincipal() {

        painelPrinc = new JPanel(new BorderLayout());
        add(painelPrinc);

        // Painel Lateral

        // Componentes
        carros = new JLabel("CARROS");
        clientes = new JLabel("CLIENTES");
        vendas = new JLabel("VENDAS");
        titulo = new JLabel("ABAS:");

        // Setando configs
        GridLayout grid = new GridLayout(4,1);
        painelComponen = new JPanel();
        painelComponen.setLayout(grid);

        // Add comp
        painelComponen.add(titulo);
        painelComponen.add(carros);
        painelComponen.add(clientes);
        painelComponen.add(vendas);

        titulo.setForeground(Color.LIGHT_GRAY);
        carros.setForeground(Color.BLACK);
        clientes.setForeground(Color.BLACK);
        vendas.setForeground(Color.BLACK);

        Font Titfonte = new Font("Arial", Font.BOLD, 14);
        Font fonte = new Font("Arial", Font.PLAIN, 12);
        titulo.setFont(Titfonte);
        carros.setFont(fonte);
        clientes.setFont(fonte);
        vendas.setFont(fonte);
        
        painelComponen.setBackground(Color.DARK_GRAY);

        // Painel lateral
        painelLate = new JPanel();
        painelLate.setBackground(Color.DARK_GRAY);
        painelLate.add(painelComponen);

        painelPrinc.add(painelLate, BorderLayout.WEST);

        // Painel para conter os cards
        CardLayout card = new CardLayout();
        painelCard = new JPanel();
        painelCard.setLayout(card);
        painelPrinc.add(painelCard, BorderLayout.CENTER);

        // criandos as tabs
        // tab1 carros
        CarrosPainel tab1 = new CarrosPainel();
        painelCard.add(tab1, "tab1");

        // tab2 clientes
        ClientesPainel tab2 = new ClientesPainel();
        painelCard.add(tab2, "tab2");

        // tab3 vendas
        VendasView tab3 = new VendasView();
        painelCard.add(tab3, "tab3");

        // Criando um JSplitPane com os dois painéis
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, painelLate, painelPrinc);
        // Definindo a divisão inicial
        splitPane.setDividerLocation(120);

        // Adicionando o JSplitPane ao conteúdo do JFrame
        add(splitPane);

        setBounds(200, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        carros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(painelCard, "tab1");
                carros.setForeground(Color.WHITE);
                clientes.setForeground(Color.BLACK);
                vendas.setForeground(Color.BLACK);

            }
        });

        clientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(painelCard, "tab2");
                carros.setForeground(Color.BLACK);
                clientes.setForeground(Color.WHITE);
                vendas.setForeground(Color.BLACK);

            }
        });
        vendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(painelCard, "tab3");
                carros.setForeground(Color.BLACK);
                clientes.setForeground(Color.BLACK);
                vendas.setForeground(Color.WHITE);

            }
        });
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
