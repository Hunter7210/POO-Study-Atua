package Exercicio2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        GridLayout gl = new GridLayout(3, 1);
        FlowLayout fl = new FlowLayout();
        CardLayout cl = new CardLayout();

        // Criando o painel principal
        JPanel painelPrinc = new JPanel();

        //Setando para cardLayout
        painelPrinc.setLayout(gl);

        // Criando os componentes
        JLabel textoLogin = new JLabel("Faça Login: ");
        JLabel textoCad = new JLabel("Faça Cadastro:");
        JLabel textoGalery = new JLabel("Veja a Galeria:");
        JButton btnLogin = new JButton("Login");
        JButton btnCad = new JButton("Cadastro");
        JButton btnGalery = new JButton("Galeria");

        // Criar os cards/telas
        JPanel cardLogin = new JPanel();
        JPanel cardCad = new JPanel();
        JPanel cardGalery = new JPanel();

        cardLogin.setLayout(gl);

        // Add os LABELS
        cardLogin.add(textoLogin);
        cardCad.add(textoCad);
        cardGalery.add(textoGalery);

        // Add os BTNS
        painelPrinc.add(btnLogin);
        painelPrinc.add(btnCad);
        painelPrinc.add(btnGalery);

        // Add ao painel principal
        painelPrinc.add(cardLogin);
        painelPrinc.add(cardCad);
        painelPrinc.add(cardGalery);

        // ADD componentes ao CardLogin

        // Criando ações para os btns
        btnLogin.addActionListener(e -> {
            cl.next(painelPrinc);
        });

        btnCad.addActionListener(e -> {
            cl.next(painelPrinc);
        });

        btnGalery.addActionListener(e -> {
            cl.next(painelPrinc);
        });

        /*
         * btnCad
         * btnGalery
         */

        // Setando o Frame
        this.add(painelPrinc);
        this.setBounds(100, 100, 300, 300);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);

    }
}
