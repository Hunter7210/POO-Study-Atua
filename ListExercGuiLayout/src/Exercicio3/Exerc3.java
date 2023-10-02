package Exercicio3;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

public class Exerc3 extends JFrame {

    // Chamando o construtor
    public Exerc3() {
        super("Ativ3 CardLayout");

        // Criando um obj dos Layouts
        BorderLayout bl = new BorderLayout();
        GridLayout gl5x1 = new GridLayout(5, 1);
        GridLayout gl3x1 = new GridLayout(3, 1);
        FlowLayout fl = new FlowLayout();
        CardLayout cl = new CardLayout();


        // Criando o painel principal
        JPanel cardPrinc = new JPanel();

        // Criando o painel dos cards
        JPanel painelCardMud = new JPanel();

        //painelCardMud.add(cardPrinc, "4"); Não posso fazer isso aqui, pois ele vai mostrar primeiro o o painel princ, e só dps ele vai gerar e mostrar os outros paineis

        // Criar os cards/telas
        JPanel cardLogin = new JPanel();
        JPanel cardCad = new JPanel();
        JPanel cardGalery = new JPanel();


        /* SETANDO OS LAYOUTS DOS PAINEIS */

        // Setando para cardLayout
        painelCardMud.setLayout(cl);

        

        // Setando os paineis do card
        cardPrinc.setLayout(bl);
        cardLogin.setLayout(gl5x1);
        cardCad.setLayout(gl5x1);
        cardGalery.setLayout(gl5x1);


        /* CRIANDO OS COMPONENTES */

        // Criando os componentes da pagina pricipal

        JLabel titInicial = new JLabel("ESCOLHA UMA ABA!");

        JButton btnLogin = new JButton("Login");
        JButton btnCad = new JButton("Cadastro");
        JButton btnGalery = new JButton("Galeria");

        // Criando elementos da pagina de login

        // Caixa para preencher
        JTextField preeNomeLogin = new JTextField("Usuario ou Email", 2);
        JTextField preeSenhaLogin = new JTextField("Senha", 2);

        // Texto/Titulo
        JLabel textNomeLogin = new JLabel("Digite seu usuário:");
        JLabel textSenhaLogin = new JLabel("Digite sua senha:");

        // Botao retorno
        JButton btnReturnAnterLogin = new JButton("Voltar");



        // Criando elementos da pagina de Cadastro

        // Caixa para preencher
        JTextField preeNomeCompCad = new JTextField("Nome completo", 2);
        JTextField preeCPFCad = new JTextField("Digite seu CPF", 2);
        JTextField preeEndCad = new JTextField("Endereço rua", 2);
        JTextField preeUFCad = new JTextField("Digite seu Estado", 2);

        // Texto/Titulo
        JLabel textNomeCompCad = new JLabel("Digite seu nome completo:");
        JLabel textCPFCad = new JLabel("Digite seu CPF:");
        JLabel textEndCad = new JLabel("Endereço rua:");
        JLabel textUFCad = new JLabel("Digite seu Estado:");

        // Botao retorno
        JButton btnReturnAnterCad = new JButton("Voltar");


        // Criando elementos da pagina de Galeria
 /*        ImageIcon image = new ImageIcon(getClass().getResource("folha.png"));

        JLabel imgLabel = new JLabel(image); */

        JButton btnReturnAnterGallery = new JButton("Voltar");


        /* 
        ADD OS CARDS AO PAINEL DE MUDANÇA DE CARDS
        */

        //Add os painel principal ao painel dos cards
        painelCardMud.add(cardPrinc, "Menu"); 

         // Add ao painel Principal
        painelCardMud.add(cardLogin, "Login");
        painelCardMud.add(cardCad, "Cadastro");
        painelCardMud.add(cardGalery, "Galeria");
        
        
        /* 
        ADD OS ELEMENTOS
        */

    JPanel alinhamentobtn = new JPanel();
    cardPrinc.add(alinhamentobtn, BorderLayout.CENTER);
    alinhamentobtn.setLayout(gl3x1);




    /* alinhamentobtn.setBorder(); */

        // Add os BTNS ao painel principal
        cardPrinc.add(titInicial, BorderLayout.NORTH);
        alinhamentobtn.add(btnLogin);
        alinhamentobtn.add(btnCad);
        alinhamentobtn.add(btnGalery);


        // ADD componentes ao CardLogin
        cardLogin.add(textNomeLogin);
        cardLogin.add(preeNomeLogin);
        cardLogin.add(textSenhaLogin);
        cardLogin.add(preeSenhaLogin);
        cardLogin.add(btnReturnAnterLogin);

        // Add componentes ao CardCad
        cardCad.add(textNomeCompCad);
        cardCad.add(preeNomeCompCad);
        cardCad.add(textCPFCad);
        cardCad.add(preeCPFCad);
        cardCad.add(textEndCad);
        cardCad.add(preeEndCad);
        cardCad.add(textUFCad);
        cardCad.add(preeUFCad);
        cardCad.add(btnReturnAnterCad);

        // Add componentes ao cardGalery
        cardGalery.add(btnReturnAnterGallery);
        /* cardGalery.add(imgLabel);
 */

        /* 
        SETANDO AS CORES
         */

        //Setando as cores do painel principal
        cardPrinc.setBackground(Color.ORANGE);

        //Setando as cores dos paineis dos cards 
        cardLogin.setBackground(Color.ORANGE);
        cardCad.setBackground(Color.ORANGE);
        cardGalery.setBackground(Color.ORANGE);
      

        //Setando as cores dos botões inicial
        btnLogin.setBackground(Color.DARK_GRAY);
        btnCad.setBackground(Color.DARK_GRAY);
        btnGalery.setBackground(Color.DARK_GRAY);
        
        //Setando as cores dos textos dos botões
        btnLogin.setForeground(Color.WHITE);
        btnCad.setForeground(Color.WHITE);
        btnGalery.setForeground(Color.WHITE);


        //Setando as cores dos botões de voltar
        btnReturnAnterLogin.setBackground(Color.DARK_GRAY);
        btnReturnAnterCad.setBackground(Color.DARK_GRAY);
        btnReturnAnterGallery.setBackground(Color.DARK_GRAY);
        
        //Setando as cores dos textos dos botões de voltar
        btnReturnAnterLogin.setForeground(Color.WHITE);
        btnReturnAnterCad.setForeground(Color.WHITE);
        btnReturnAnterGallery.setForeground(Color.WHITE);
        


        /* CRIANDO AÇÕES PARA OS BOTÕES */


        // Criando ação para pagina de login
    String nomedospaineis;

        btnLogin.addActionListener(e -> {
            cl.show(painelCardMud, btnLogin.getText());
        });
            
        // Criando ação para pagina anterior/inicial
        btnReturnAnterLogin.addActionListener(e -> {
            /* cl.previous(painelCardMud); */
            cl.show(painelCardMud, "Menu");
        });        


        // Criando ação para pagina de cadastro
        btnCad.addActionListener(e -> {/* 
            cl.show(painelCardMud, "Cadastro"); */
            if (btnCad.getText()== "Login") {
                
            }
            btnCad.setText("Login");
            cl.show(painelCardMud, btnCad.getText());
            /* cl.show(painelCardMud, "Cadastro"); */
        });

        // Criando ação para pagina anterior/inicial
        btnReturnAnterCad.addActionListener(e -> {
            /* cl.previous(painelCardMud); */
            cl.show(painelCardMud, "Menu");
        });

        // Criando ação para pagina de Galeria
        btnGalery.addActionListener(e -> {
            /* cl.next(painelCardMud); */
            cl.show(painelCardMud, "Galeria");
        });
    
        // Criando ação para pagina anterior/inicial
        btnReturnAnterGallery.addActionListener(e -> {
        cl.previous(painelCardMud);
        cl.show(painelCardMud, "Menu");
        });
        
        
        /* 
            SETANDO AS CONFIGS DO FRAME
        */
        
        this.add(painelCardMud);
        this.setBounds(500, 200, 400, 400);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);

    }
}
