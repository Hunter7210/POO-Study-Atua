import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.io.Serializable;

import java.util.List;

public class OperacoesAgenda {
    private List<Usuario> usuarios;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public OperacoesAgenda(List<Usuario> usuarios, DefaultTableModel tableModel, JTable table) {
        // Definindo os elemetos do construtor
        this.usuarios = usuarios;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Metodo
    public void cadastrarAgenda(String nome, String idade) {
        int idadeInt = Integer.parseInt(idade);
        Usuario usuario = new Usuario(nome, idadeInt);
        usuarios.add(usuario);
        atualizarTabela();
    }

    public void atualizarAgenda(int linhaSelecionada, String nome, String idade) {
        if (linhaSelecionada != -1) {
            int idadeInt = Integer.parseInt(idade);
            Usuario usuario = new Usuario(nome, idadeInt);
            usuarios.set(linhaSelecionada, usuario);
            atualizarTabela();
        }
    }

    public void apagarAgenda(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            usuarios.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    public void apagarTodos() {
        usuarios.clear();
        atualizarTabela();
    }

    public void salvarAgenda() {
        Serializacao.serializar("dadosAgenda.txt", usuarios);
    }

    public void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() });
        }
    }

}

