package View;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Model.Carros;
import Model.Clientes;

public class VendasView extends JPanel {

    private JComboBox<String> carrosComboBox;
    private List<Carros> carros;

    private JComboBox<String> clienteComboBox;
    private List<Clientes> clientes;

    public VendasView() {
        super();

        // Listar carros cadastrados no JCombobox
        carrosComboBox = new JComboBox<>();
        // Listar clientes cadastrados no JCombobox
        clienteComboBox = new JComboBox<>();

        // Preencha o JComboBox com os campos
        // Carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecionar o carro");
        // Clientes
        clientes = new ClientesDAO().lisarClientes();
        carrosComboBox.addItem("Selecionar o carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + "" + carro.getModelo() + "" + carro.getPlaca());
        }
        add(carrosComboBox);
    }

}
