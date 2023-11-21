package View;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Connection.CarrosDAO;
import Model.Carros;

public class VendasView extends JPanel {
    JComboBox<String> carrosComboBox;
    List<Carros> carros;

    public VendasView() {
        super();

        //Listar carros cadastrados no JCombobox
        carrosComboBox = new JComboBox<>();

        //Preencha o JComboBox com os campos
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecionar o carro");

        for (Carros carro : carros){
            carrosComboBox.addItem(carro.getMarca() + "" + carro.getModelo() + "" + carro.getPlaca());
        }
        add(carrosComboBox);
    }

}
