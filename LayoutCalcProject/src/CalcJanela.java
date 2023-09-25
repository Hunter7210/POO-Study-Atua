import javax.swing.*;


public class CalcJanela extends JFrame {
    public CalcJanela() {
        super("JANELA PRINCI / CALCULADORA");

        this.add(new CalcAbas());

        this.setDefaultCloseOperation(2);
        this.pack(); // Compacta os elementos, ele redimensiona
        this.setVisible(true);

        
    }
}
