import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import java.io.Serializable;

import java.util.List;

public class OperacoesAgenda {
    private List<Usuario> agendamentos;
    private DefaultTableModel tableModel;
    private JTable table;


    
    public OperacoesAgenda(List<Usuario> agendamentos, DefaultTableModel tableModel, JTable table) {
        this.agendamentos = agendamentos;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Metodo
    public void cadastrarAgenda(String data, String hora, Usuario usuario, String descricao ) {
        Agenda agendamento = new Agenda(data, hora, usuario, descricao);
        agendamentos.add(agendamento);
        atualizarTabela();
    }

    public void atualizarAgenda(int linhaSelecionada, String nome, String idade) {
        if (linhaSelecionada != -1) {
            int idadeInt = Integer.parseInt(idade);
            Usuario usuario = new Usuario(nome, idadeInt);
            agendamentos.set(linhaSelecionada, usuario);
            atualizarTabela();
        }
    }

    public void apagarAgenda(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            agendamentos.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    public void apagarTodos() {
        agendamentos.clear();
        atualizarTabela();
    }

    public void salvarAgenda() {
        Serializacao.serializar("dadosAgenda.txt", agendamentos);
    }

    public void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Agenda agendamento : agendamentos) {
            tableModel.addRow(new Object[] { agendamentos.getNome(), agendamentos.getIdade() });
        }
    }

}

