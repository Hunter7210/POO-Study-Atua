import java.util.logging.Handler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;

/**
 * UtlizFormHanddler
 */
public class UtlizFormHanddler extends JFrame {

    // Atributos
    private JButton btnGo;
    private JTextField resposNome, resposSobre;
    private JLabel respConcat;

    // Construtor
    public UtlizFormHanddler() {
        super();

        // Criando obj dos Layouts
        GridLayout gl = new GridLayout(3, 2);
        FlowLayout fl = new FlowLayout();

        // Criando painel principal
        JPanel painelPrinc = new JPanel(gl);

        // Add o painel principal a janela
        this.add(painelPrinc);

        // Criando os elementos
        JLabel nomeLabel = new JLabel("Nome: ");
        JLabel sobreLabel = new JLabel("Sobrenome: ");
        resposNome = new JTextField();
        resposSobre = new JTextField();
        respConcat = new JLabel();
        btnGo = new JButton("Enviar");

        // Add os componentes ao painel principal
        painelPrinc.add(nomeLabel);
        painelPrinc.add(resposNome);
        painelPrinc.add(sobreLabel);
        painelPrinc.add(resposSobre);
        painelPrinc.add(respConcat);
        painelPrinc.add(btnGo);

        // Usando o handler
        Handler evento = new Handler();
        btnGo.addActionListener(evento); // ActionListener sempre ira ter

        // Setando as configs da janela
        this.setVisible(true);
        this.setBackground(Color.CYAN);
        /* this.setLocation(revalidate(),CENTER_ALIGNMENT); */
        this.setBounds(500, 100, 300, 150);
        this.setDefaultCloseOperation(2);

        // Chamar o handler dentro do construtor
    }

    public class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Para chamar chamar os elementos que estão dentro do construtor é necessário criar atributos
            respConcat.setText(resposNome.getText() + "" + resposSobre.getText());
            resposNome.setText("");
            resposSobre.setText("");
            
        }
        // Handler é um implemento de ActionListener, implements faz com que a Handler
        // deve conter algum metodo da ActionLister
        // Um atalho para a criação dos metodos é usar o Quick
    }

}
