package View;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Model.Carros;
import Model.Clientes;

public class VendasView extends JPanel {

    private JComboBox<String> carrosComboBox;
    private List<Carros> carros;
    private JButton enviar, limpar;
    private JComboBox<String> clienteComboBox;
    private List<Clientes> clientes;

    public VendasView() {
        super();

        JPanel painelPrinc = new JPanel();
        add(painelPrinc);

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
        clienteComboBox.addItem("Selecionar o cliente");
        
        //Preenche o comboBox 
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + "" + carro.getModelo() + "" + carro.getPlaca());
        }

        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + "" + carro.getModelo() + "" + carro.getPlaca());
        }

        //Adiciona os componentes
        painelPrinc.add(carrosComboBox);
        painelPrinc.add(clienteComboBox);
    }

}
