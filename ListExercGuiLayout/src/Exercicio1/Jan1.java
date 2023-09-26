package Exercicio1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Jan1 extends JFrame {

    public Jan1() {
        super("Exerc1");

        // Criação de um painel principal
        JPanel mainPanel = new JPanel();
        
        // setLayout - cardLayout
        CardLayout cardlay = new CardLayout();
        mainPanel.setLayout(cardlay);

        // Criar os cards para adicionar o main
        JPanel cardprim = new JPanel();
        cardprim.add(new JLabel("Card 1"));
    
        JPanel cardseg = new JPanel();
        cardseg.add(new JLabel("Card 2"));

        JPanel cardterc = new JPanel();
        cardterc.add(new JLabel("Card 3"));

        /* Criação de componente */
        JButton btn1Next = new JButton("Next");
        JButton btn2Next = new JButton("Next");
        JButton btn3Next = new JButton("Next");

        cardprim.add(btn1Next);
        cardseg.add(btn2Next);  
        cardterc.add(btn3Next);

        // ADCIONANDO CARDS AO PAINEL PRINCIPAL
        mainPanel.add(cardprim);
        mainPanel.add(cardseg);
        mainPanel.add(cardterc);

        // Setando o Frame
        this.add(mainPanel);
        this.setBounds(100, 100, 300, 300);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);

        // Criar ActionListener para o botão
        btn1Next.addActionListener(e -> {
            cardlay.next(mainPanel);
        });
        btn2Next.addActionListener(e -> {
            cardlay.next(mainPanel);
        });
        btn3Next.addActionListener(e -> {
            cardlay.next(mainPanel);
        });
    }

}
/*
 * // Criação dos painéis/abas
 * JPanel primPainel = new JPanel();
 * JPanel secPainel = new JPanel();
 * JPanel tercPainel = new JPanel();
 * JPanel painelCont = new JPanel();
 * 
 * // Criação dos Componentes
 * JButton botaoPrim = new JButton("Mudar para painel 2");
 * JButton botaoSec = new JButton("Mudar para painel 3");
 * JButton botaoTerc = new JButton("Mudar para painel 1");
 * 
 * // Criando um obj de CardLayout
 * CardLayout carLayout = new CardLayout();
 * 
 * // Chamando o construtor
 * public Jan1() {
 * 
 * // Atribuindo o layout ao card princ
 * painelCont.setLayout(carLayout);
 * 
 * // Atribuindo os paines ao painel principal
 * painelCont.add(primPainel, "1");
 * painelCont.add(secPainel, "2");
 * painelCont.add(tercPainel, "3");
 * 
 * // Atribuindo os compoenetes aos paineis
 * primPainel.add(botaoPrim);
 * primPainel.add(botaoSec);
 * primPainel.add(botaoTerc);
 * 
 * carLayout.show(painelCont, "1");
 * }
 * public void actionPerformed(ActionEvent evento){
 * botaoPrim.setVisible(true);
 * }
 * 
 * }
 * 
 * public void actionPerformed(ActionEvent evento) {
 * carLayout.show(painelCont, "2");
 * 
 * botaoPrim.
 * 
 */