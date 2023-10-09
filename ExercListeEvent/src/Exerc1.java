import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Exerc1 extends JFrame {
    // Criando os atributos

    // Criação dos obj
    private GridLayout gl4x1 = new GridLayout(4, 1);
    private GridLayout gl1x2 = new GridLayout(1, 2);
    private FlowLayout fl = new FlowLayout();
    private BorderLayout bl = new BorderLayout();

    // Criação dos paineis
    private JPanel painelPrinc = new JPanel(gl4x1);
    private JPanel painelTit = new JPanel(fl);
    private JPanel painelUltTec = new JPanel(bl);
    private JPanel painelContText = new JPanel(gl1x2);
    private JPanel painelDigitText = new JPanel(gl1x2);

    //Criação dos textos
    private JLabel textTit = new JLabel("Rastreamento de teclado");
    private JLabel textUltTec = new JLabel("Ultima tecla:");
    private JLabel textDig = new JLabel("Digite seu texto aqui:");
    private JLabel textVerDig = new JLabel("Veja o que digitou aqui:");

    //Criação da area de texto
    private JTextArea areaTextUltTec = new JTextArea(4, 8);
    private JTextArea verTextDig = new JTextArea("Veja aqui");

    //Criação da caixa de texto
    private JTextField digText = new JTextField("Digite aqui");
    

    //Construtor
    public Exerc1() {
        super();

        // Adicionando os paineis
        painelPrinc.add(painelTit);
        painelPrinc.add(painelUltTec);
        painelPrinc.add(painelContText);
        painelPrinc.add(painelDigitText);

        // Adicionando os componentes
        painelTit.add(textTit);

        painelUltTec.add(textUltTec, BorderLayout.CENTER);
        painelUltTec.add(areaTextUltTec, BorderLayout.EAST);

        painelContText.add(textDig);
        painelContText.add(textVerDig);

        painelDigitText.add(digText);
        painelDigitText.add(verTextDig);

        //Chamando o Handler
        Handler evento = new Handler();
        areaTextUltTec.addKeyListener(evento);
        

        //Setando as config do painel principal
        this.add(painelPrinc);
        this.setVisible(true);
        this.setDefaultCloseOperation(2);
        this.setBounds(300, 400, 400, 400);

    }

    //Criação do Handler
    public class Handler implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            areaTextUltTec.setText(digText.getText());
        }

    }
}
