import javax.swing.*;

public class CalcAbas extends JTabbedPane {
    public CalcAbas() {
        super();

        this.add("Calculadora normal", new CalcNormal());
        this.add("Calculadora IMC", new CaclImc());
        this.add("Calculadora NO LAYOUT", new Calculadora());
        this.add("Calculadora Cmbustível", new CalcCombustivel());

    }
}
