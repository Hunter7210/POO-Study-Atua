import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Frame principaçç da App");
        setDefaultCloseOperation(2);
       /*  this.setVisible(true); */

        JTabbedPane abas = new JTabbedPane();
        abas.add("Cadastro Usuários", new Cadastro());
        abas.add("Agendamento", new CadastroAgendamento());
        add(abas);
    }

    public void run() {
        pack();
        this.setVisible(true);
    }

}