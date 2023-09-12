import javax.swing.*;
import java.awt.*;

public class CalcNormal extends JPanel {
    public CalcNormal() {

        JPanel painelPrinc = new JPanel(new BorderLayout());
        this.add(painelPrinc);
        this.setBackground(Color.ORANGE);

        painelPrinc.setBackground(Color.BLUE);

        // add Jpanel
        JPanel displayResult = new JPanel(new FlowLayout());
        painelPrinc.add(displayResult, BorderLayout.NORTH);

        displayResult.add(new JTextArea(5,15));

        JPanel botoesCalc = new JPanel(new GridLayout(4, 4));
        painelPrinc.add(botoesCalc, BorderLayout.CENTER);



        String valores[] = { "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "/", "0", ".", "+" };

        for (int i = 0; i < valores.length; i++) {
            botoesCalc.add(new JButton(valores[i]));
        }

    }
}
