package Exercicio2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Exerc2 extends JFrame {

    // Chamando o construtor
    public Exerc2() {
        super("Ativ3 CardLayout");

        // Criando um obj dos Layouts
        BorderLayout bl = new BorderLayout();
        GridLayout gl = new GridLayout(5, 1);
        FlowLayout fl = new FlowLayout();
        CardLayout cl = new CardLayout();

        // Criando o painel principal
        JPanel painelCardMud = new JPanel();

        // Criando o painel dos cards
        JPanel painelPrinc = new JPanel();

        painelCardMud.add(painelPrinc, "4");

        // Criar os cards/telas
        JPanel cardLogin = new JPanel();
        JPanel cardCad = new JPanel();
        JPanel cardGalery = new JPanel();

        /* SETANDO OS LAYOUTS DOS PAINEIS */

        // Setando para cardLayout
        painelCardMud.setLayout(cl);

        // Setando para
        painelPrinc.setLayout(fl);

        // Setando os paineis do card
        cardLogin.setLayout(gl);
        cardCad.setLayout(gl);
        cardGalery.setLayout(gl);

        /* CRIANDO OS COMPONENTES */

        // Criando os componentes da pagina pricipal

        JLabel textoLogin = new JLabel("Faça Login: ");
        JLabel textoCad = new JLabel("Faça Cadastro:");
        JLabel textoGalery = new JLabel("Veja a Galeria:");

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

        // Add os LABELS
        /*
         * cardLogin.add(textoLogin);
         * cardCad.add(textoCad);
         * cardGalery.add(textoGalery);
         * 
         */

        // Add ao painel Principal
        painelCardMud.add(cardLogin,"1");
        painelCardMud.add(cardCad,"2");
        painelCardMud.add(cardGalery, "3");

        // Add os elementos a Janela dos cards

        // Add os BTNS
        painelCardMud.add(painelPrinc,"4");
        painelPrinc.add(btnLogin);
        painelPrinc.add(btnCad);
        painelPrinc.add(btnGalery);

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

        /* CRIANDO AÇÕES PARA OS BOTÕES */

        // Criando ação para pagina seguinte
        btnLogin.addActionListener(e -> {
            /* 
            if (cl.equals(cardLogin)) {
                cl.next(painelCardMud); */
                /* cl.next(painelCardMud); */
                 cl.show(painelCardMud, "1");

            /* }else{
                JOptionPane exibir = new JOptionPane();

                exibir.showMessageDialog(null, "Não foi");
            }
 */
        });
        // Criando ação para pagina anterior/inicial
        btnReturnAnterLogin.addActionListener(e -> {
            /* cl.previous(painelCardMud); */
            cl.show(painelCardMud, "4");
        });

        // Criando ação para pagina seguinte
        btnCad.addActionListener(e -> {
            cl.show(painelCardMud, "2");
        });
        // Criando ação para pagina anterior/inicial
        btnReturnAnterCad.addActionListener(e -> {
            /* cl.previous(painelCardMud); */
            cl.show(painelCardMud, "4");
        });

        // Criando ação para pagina seguinte
        btnGalery.addActionListener(e -> {
            /* cl.next(painelCardMud); */
            cl.show(painelCardMud, "3");
        });
        /*
         * // Criando ação para pagina anterior/inicial
         * btnReturnAnterGallery.addActionListener(e -> {
         * cl.previous(painelCardMud);
         * cl.show(painelCardMud, "4");
         * });
         */

        // Setando as confis do Frame
        this.add(painelCardMud);
        this.setBounds(100, 100, 300, 300);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);

    }
}
