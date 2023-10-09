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

    //Atributos
    private JButton btnGo;
    private JTextField resposNome, resposSobre;
    private JLabel respConcat;

    //Construtor
    public ExercTesteBtn() {
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

        // Chamando/criando o evento
        // CHAMOU O EVENTO PEÇO PELA FORMA MAIS COMUM
        // Para isso funcionar, é necessário importar os eventos "import
        // java.awt.event.ActionEvent; import java.awt.event.ActionListener;"





        //METODO TRADIOCINAL
        /* btnGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                respConcat.setText(resposNome.getText() + "" + resposSobre.getText());
                resposNome.setText("");
                resposSobre.setText("");
            }
        }); */


        //Usando o handler
        Handler evento = new Handler();
        btnGo.addActionListener(evento); //ActionListener sempre ira ter

        // Setando as configs da janela
        this.setVisible(true);
        this.setBackground(Color.CYAN);
        /* this.setLocation(revalidate(),CENTER_ALIGNMENT); */
        this.setBounds(500, 100, 300, 150);
        this.setDefaultCloseOperation(2);

    }

    // Tratamento de eventos pelo manipulador
    // Criar a classe handler fora do construtor

    public class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            respConcat.setText(resposNome.getText() + "" + resposSobre.getText());
            resposNome.setText("");
            resposSobre.setText("");
//Para chamar chamar os elementos que estão dentro do construtor
        }
        // Handler é um implemento de ActionListener, implements faz com que a Handler
        // deve conter algum metodo da ActionLister
        // Um atalho para a criação dos metodos é usar o Quick

    }

}