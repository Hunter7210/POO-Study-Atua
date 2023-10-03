import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ExercTesteBtn
 */
public class ExercTesteBtn extends JFrame /* implements ActionListener */ {

    private JButton btnGo;

    public ExercTesteBtn(){
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
        JTextField resposNome = new JTextField();
        JTextField resposSobre = new JTextField();
        JLabel respConcat = new JLabel();
        JButton btnGo = new JButton("Enviar");

        // Add os componentes ao painel principal
        painelPrinc.add(nomeLabel);
        painelPrinc.add(resposNome);
        painelPrinc.add(sobreLabel);
        painelPrinc.add(resposSobre);
        painelPrinc.add(respConcat);
        painelPrinc.add(btnGo);


        //Chamando/criando o evento
        //CHAMOU O EVENTO PEÇO PELA FORMA MAIS COMUM
        //Para isso funcionar, é necessário importar os eventos "import java.awt.event.ActionEvent; import java.awt.event.ActionListener;"

        btnGo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
            
            respConcat.setText(resposNome.getText()+""+resposSobre.getText());
            resposNome.setText("");
            resposSobre.setText("");   
        }});

        // Setando as configs da janela
        this.setVisible(true);
        
        this.setBackground(Color.CYAN);
        /* this.setLocation(revalidate(),CENTER_ALIGNMENT); */
        this.setBounds(500, 100, 300, 150);
        this.setDefaultCloseOperation(2);

    }


}