package Exercicio5;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Exerc5 extends JFrame { // Isso significa que o Exerc5 é uma subClasse de JFrame, transformando do a em
                                     // uma Janela

    public Exerc5() {
        super("Exercicio 5 - Jogo");

        // Criando obj dos Laoyuts
        CardLayout cl = new CardLayout();
        BorderLayout bl = new BorderLayout();
        FlowLayout fl = new FlowLayout();
        GridLayout gl = new GridLayout(4, 1);

        // CRIAÇÃO DOS PAINEIS

        // Criando a tela inicial com o layout CardLayout
        JPanel painelPrinc = new JPanel();
        JPanel cardTelaStart = new JPanel();
        JPanel cardTelaJogo1 = new JPanel();
        JPanel cardTelaJogo2 = new JPanel();
        JPanel cardTelaJogo3 = new JPanel();
        JPanel cardTelaJogo4 = new JPanel();
        JPanel cardTelaJogo5 = new JPanel();
        JPanel cardTelaPontF = new JPanel();
        JPanel cardTelaPerdeu = new JPanel();

        // Setando o painel principal a janela
        this.add(painelPrinc);

        // ATRIBUINDO OS LAYOUTS

        // Atribuindo os layouts nos cards
        painelPrinc.setLayout(cl);
        cardTelaStart.setLayout(fl);
        cardTelaJogo1.setLayout(gl);
        cardTelaJogo2.setLayout(gl);
        cardTelaJogo3.setLayout(gl);
        cardTelaJogo4.setLayout(gl);
        cardTelaJogo5.setLayout(gl);
        cardTelaPontF.setLayout(gl);
        cardTelaPerdeu.setLayout(gl);

        // Setando os paineis ao painelPric
        painelPrinc.add(cardTelaStart, "TelaInicGam");
        painelPrinc.add(cardTelaJogo1, "Tela1Jogo");
        painelPrinc.add(cardTelaJogo2, "Tela2Jogo");
        painelPrinc.add(cardTelaJogo3, "Tela3Jogo");
        painelPrinc.add(cardTelaJogo4, "Tela4Jogo");
        painelPrinc.add(cardTelaJogo5, "Tela5Jogo");
        painelPrinc.add(cardTelaPontF, "TelaVerPontFin");
        painelPrinc.add(cardTelaPerdeu, "TelaVcPerdeu");

        /*
         * CRIANDO OS COMPONENTES
         */

        // Criando os componentes para o Start do jogo
        JLabel titPagIniciar = new JLabel("RESPONDA O QUIZ CORRETAMENTE");
        JButton botaoIniciarGame = new JButton("Iniciar");

        // Criando os componentes para a Pag 1
        JLabel titPagJogo1 = new JLabel("QUESTÃO 1:");
        JLabel pergunPagJogo1 = new JLabel("Questao");
        JTextArea camAtribRespPag1 = new JTextArea();
        JButton botaoRespPag1 = new JButton("Validar");

        // Criando os componentes para a Pag 2
        JLabel titPagJogo2 = new JLabel("QUESTÃO 2:");
        JLabel pergunPagJogo2 = new JLabel("Questao");
        JTextArea camAtribRespPag2 = new JTextArea();
        JButton botaoRespPag2 = new JButton("Validar");

        // Criando os componentes para a Pag 3
        JLabel titPagJogo3 = new JLabel("QUESTÃO 3:");
        JLabel pergunPagJogo3 = new JLabel("Questao");
        JTextArea camAtribRespPag3 = new JTextArea();
        JButton botaoRespPag3 = new JButton("Validar");

        // Criando os componentes para a Pag 4
        JLabel titPagJogo4 = new JLabel("QUESTÃO 4:");
        JLabel pergunPagJogo4 = new JLabel("Questao");
        JTextArea camAtribRespPag4 = new JTextArea();
        JButton botaoRespPag4 = new JButton("Validar");

        // Criando os componentes para a Pag 5
        JLabel titPagJogo5 = new JLabel("QUESTÃO 5:");
        JLabel pergunPagJogo5 = new JLabel("Questao");
        JTextArea camAtribRespPag5 = new JTextArea();
        JButton botaoRespPag5 = new JButton("Validar");

        // Criando os componentes para a pag pontuação
        JLabel titPagPontF = new JLabel("PONTUAÇÃO");
        JLabel showPagPontF = new JLabel("1");
        JButton btnRecomGame = new JButton("Voltar a Home");

        // Criando os componentes para a pag de perdedor
        JLabel titPagPerdeu = new JLabel("PONTUAÇÃO");
        JLabel showPagPerdeu = new JLabel("1");

        /*
         * ADD OS COMPONENTES AO PAINEIS
         */

        // Add a Tela ao painel Start
        cardTelaStart.add(titPagIniciar);
        cardTelaStart.add(botaoIniciarGame);

        // Add a Tela ao painel de Jogo 1
        cardTelaJogo1.add(titPagJogo1);
        cardTelaJogo1.add(pergunPagJogo1);
        cardTelaJogo1.add(camAtribRespPag1);
        cardTelaJogo1.add(botaoRespPag1);

        // Add a Tela ao painel de Jogo 2
        cardTelaJogo2.add(titPagJogo2);
        cardTelaJogo2.add(pergunPagJogo2);
        cardTelaJogo2.add(camAtribRespPag2);
        cardTelaJogo2.add(botaoRespPag2);

        // Add a Tela ao painel de Jogo 3
        cardTelaJogo3.add(titPagJogo3);
        cardTelaJogo3.add(pergunPagJogo3);
        cardTelaJogo3.add(camAtribRespPag3);
        cardTelaJogo3.add(botaoRespPag3);

        // Add a Tela ao painel de Jogo 4
        cardTelaJogo4.add(titPagJogo4);
        cardTelaJogo4.add(pergunPagJogo4);
        cardTelaJogo4.add(camAtribRespPag4);
        cardTelaJogo4.add(botaoRespPag4);

        // Add a Tela ao painel de Jogo 5
        cardTelaJogo5.add(titPagJogo5);
        cardTelaJogo5.add(pergunPagJogo5);
        cardTelaJogo5.add(camAtribRespPag5);
        cardTelaJogo5.add(botaoRespPag5);

        // Add a Tela ao painel de Pontuação
        cardTelaPontF.add(titPagPontF);
        cardTelaPontF.add(showPagPontF);
        cardTelaPontF.add(btnRecomGame);
    
        // Add a Tela ao painel de Pontuação
        cardTelaPerdeu.add(titPagPerdeu);
        cardTelaPerdeu.add(showPagPerdeu);

        /*
         * CRIANDO AÇÕES PARA OS BTNS
         */

        String repostasPerg[] = new String[] { "RESP1", "RESP2", "RESP3", "RESP4", "RESP5" };

        int vidas[] =new int[3];

        botaoIniciarGame.addActionListener(e -> {
            cl.show(painelPrinc, "Tela1Jogo");
        });

        botaoRespPag1.addActionListener(e -> {
            if (camAtribRespPag1.getText().equals(repostasPerg[1])) {
                cl.show(painelPrinc, "Tela2Jogo");

            } else {
                JOptionPane.showMessageDialog(null, "Erroou");
            }
        });

        botaoRespPag2.addActionListener(e -> {
            cl.show(painelPrinc, "Tela3Jogo");
        });

        botaoRespPag3.addActionListener(e -> {
            cl.show(painelPrinc, "Tela4Jogo");
        });

        botaoRespPag4.addActionListener(e -> {
            cl.show(painelPrinc, "Tela5Jogo");
        });

        botaoRespPag5.addActionListener(e -> {
            cl.show(painelPrinc, "TelaVerPontFin");
        });

        btnRecomGame.addActionListener(e -> {
            cl.show(painelPrinc, "TelaInicGam");
        });

        /*
         * SETANDO AS CONFIGS DO FRAME
         */
        this.setBounds(500, 200, 400, 400);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);

    }
}
