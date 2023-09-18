import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TabbedPaneEx extends JFrame {

    public TabbedPaneEx() {
        super("Ex JTabbedPane");
    
    JTabbedPane janelaAbas = new JTabbedPane();

    //criando as abas, e adiiconando seus componentes
    JPanel primAba = new JPanel();
        primAba.add(new JButton("Primordial BTN"));
        primAba.add(new JButton("mordial BTN"));
        primAba.add(new JButton("Trimordial BTN"));

    
    JPanel segAba = new JPanel();
        segAba.add(new JTextField());

        //Adicionar abas ao Jtabbed Pane
        janelaAbas.add("AbaBTN",primAba);
        janelaAbas.add("AbaText",segAba);

    this.add(janelaAbas);


    //CONFIG FRAME
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 100, 100);
        this.setVisible(true);
    }
}
