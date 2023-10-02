package Exercicio5;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Exerc5 extends JFrame { // Isso significa que o Exerc5 é uma subClasse de JFrame, transformando do a em
                                     // uma Janela
    /*
     * RESPOSTAS CERTAS
     */

    // Criando um array para conter as respostas corretas
    String repostasPerg[] = new String[] { "RESP1", "RESP2", "RESP3", "RESP4", "RESP5" };

    // Criando um array para conter as vidas
    ArrayList vidas = new ArrayList<>();

    ArrayList pontuacao = new ArrayList<>();

    public Exerc5() {
        super("Exercicio 5 - Jogo");

        // Criando obj dos Laoyuts
        CardLayout cl = new CardLayout();
        BorderLayout bl = new BorderLayout();
        FlowLayout fl = new FlowLayout();
        GridLayout gl = new GridLayout(4, 1);

        // CRIAÇÃO DOS PAINEIS

        // Criando a tela inicial com o layout CardLayout
        JPanel painelPrinc = new JPanel(cl);
        JPanel cardTelaStart = new JPanel(fl);
        JPanel cardTelaJogo1 = new JPanel(gl);
        JPanel cardTelaJogo2 = new JPanel(gl);
        JPanel cardTelaJogo3 = new JPanel(gl);
        JPanel cardTelaJogo4 = new JPanel(gl);
        JPanel cardTelaJogo5 = new JPanel(gl);
        JPanel cardTelaPontF = new JPanel(gl);
        JPanel cardTelaPerdeu = new JPanel(gl);

        // Setando o painel principal a janela
        this.add(painelPrinc);

        // ATRIBUINDO OS LAYOUTS

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
        JTextField camAtribRespPag1 = new JTextField();
        JButton botaoRespPag1 = new JButton("Validar");

        // Criando os componentes para a Pag 2
        JLabel titPagJogo2 = new JLabel("QUESTÃO 2:");
        JLabel pergunPagJogo2 = new JLabel("Questao");
        JTextField camAtribRespPag2 = new JTextField();
        JButton botaoRespPag2 = new JButton("Validar");

        // Criando os componentes para a Pag 3
        JLabel titPagJogo3 = new JLabel("QUESTÃO 3:");
        JLabel pergunPagJogo3 = new JLabel("Questao");
        JTextField camAtribRespPag3 = new JTextField();
        JButton botaoRespPag3 = new JButton("Validar");

        // Criando os componentes para a Pag 4
        JLabel titPagJogo4 = new JLabel("QUESTÃO 4:");
        JLabel pergunPagJogo4 = new JLabel("Questao");
        JTextField camAtribRespPag4 = new JTextField();
        JButton botaoRespPag4 = new JButton("Validar");

        // Criando os componentes para a Pag 5
        JLabel titPagJogo5 = new JLabel("QUESTÃO 5:");
        JLabel pergunPagJogo5 = new JLabel("Questao");
        JTextField camAtribRespPag5 = new JTextField();
        JButton botaoRespPag5 = new JButton("Validar");

        // Criando os componentes para a pag pontuação
        JLabel titPagPontF = new JLabel("PONTUAÇÃO");
        JLabel showPagPontF = new JLabel("");
        JButton btnRecomGame = new JButton("Voltar a Home");

        // Criando os componentes para a pag de perdedor
        JLabel titPagPerdeu = new JLabel("YOU LOSE");
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
        cardTelaPerdeu.add(btnRecomGame);

        /*
         * CRIANDO AÇÕES PARA OS BTNS
         */

        botaoIniciarGame.addActionListener(e -> {
            cl.show(painelPrinc, "Tela1Jogo");
        });

        botaoRespPag1.addActionListener(e -> {
            if (camAtribRespPag1.getText().equals(repostasPerg[0])) {
                
                pontuacao.add("-");

                showPagPontF.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "Tela2Jogo");

            } else {
                vidas.add("-");

                showPagPerdeu.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "TelaVcPerdeu");

                if (vidas.size() == 3) {
                    titPagPerdeu.setText("SUAS CHANCES SE ESGOTARAM");
                    cl.show(painelPrinc, "TelaVcPerdeu");
                }
            }
        });

        botaoRespPag2.addActionListener(e -> {

            if (camAtribRespPag2.getText().equals(repostasPerg[1])) {
                pontuacao.add("-");
                showPagPontF.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "Tela3Jogo");

            } else {
                vidas.add("-");
                showPagPerdeu.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "TelaVcPerdeu");

                if (vidas.size() == 3) {

                    titPagPerdeu.setText("SUAS CHANCES SE ESGOTARAM");
                    cl.show(painelPrinc, "TelaVcPerdeu");

                }

            }

        });

        botaoRespPag3.addActionListener(e -> {

            if (camAtribRespPag3.getText().equals(repostasPerg[2])) {

                pontuacao.add("-");
                showPagPontF.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "Tela4Jogo");

            } else {
                vidas.add("-");

                showPagPerdeu.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "TelaVcPerdeu");
                if (vidas.size() == 3) {

                    titPagPerdeu.setText("SUAS CHANCES SE ESGOTARAM");
                    cl.show(painelPrinc, "TelaVcPerdeu");

                }

            }

        });

        botaoRespPag4.addActionListener(e -> {

            if (camAtribRespPag4.getText().equals(repostasPerg[3])) {
                pontuacao.add("-");
                showPagPontF.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "Tela5Jogo");

            } else {
                vidas.add("-");
                showPagPerdeu.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "TelaVcPerdeu");
                if (vidas.size() == 3) {
                    titPagPerdeu.setText("SUAS CHANCES SE ESGOTARAM");
                    cl.show(painelPrinc, "TelaVcPerdeu");

                }

            }

        });

        botaoRespPag5.addActionListener(e -> {

            if (camAtribRespPag5.getText().equals(repostasPerg[4])) {
                pontuacao.add("-");
                showPagPontF.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "TelaVerPontFin");

            } else {
                vidas.add("-");
                showPagPerdeu.setText("Sua pontuação é de: " + pontuacao.size());
                cl.show(painelPrinc, "TelaVcPerdeu");

                if (vidas.size() == 3) {
                    titPagPerdeu.setText("SUAS CHANCES SE ESGOTARAM");
                    cl.show(painelPrinc, "TelaVcPerdeu");
                }

            }
        });

        btnRecomGame.addActionListener(e -> {
            if (vidas.size() == 3) {
                pontuacao.clear();
                vidas.clear();
                titPagPerdeu.setText("SUAS CHANCES SE ESGOTARAM");
                cl.show(painelPrinc, "TelaInicGam");
            } else {

                cl.show(painelPrinc, "Tela1Jogo");

            }
        });

        /*
         * SETANDO AS CONFIGS DO FRAME
         */
        this.setBounds(500, 200, 400, 400);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);

    }
}
