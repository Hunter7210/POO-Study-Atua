import java.awt.*;
import javax.swing.*;

/* LAYOUTS UTILIZADOS: 
 * BorderLayout();
 * GridLayout();
 * 
*/
public class CaclImc extends JPanel {
    public CaclImc() {
        super();

        //Setando o Jpanel principal como BoderLayout
        this.setLayout(new BorderLayout());

        JPanel esqueda = new JPanel();
        JPanel direita = new JPanel();

        this.add(esqueda, BorderLayout.WEST);
        this.add(direita, BorderLayout.EAST);

        JPanel topo = new JPanel(new BorderLayout());
        this.add(topo, BorderLayout.NORTH);

        JPanel contemTopo = new JPanel(new GridLayout());
        topo.add(contemTopo);

        // ADD OS COMPONENTES
        contemTopo.add(new JButton("HOMEM")/* , BorderLayout.NORTH */);
        contemTopo.add(new JButton("MULHER")/* BorderLayout.NORTH */);

        // Criando um painel para conter os elementos do meio do janela
        JPanel preenchimentInf = new JPanel(new BorderLayout());
        this.add(preenchimentInf, BorderLayout.CENTER);

        JPanel painelcontem = new JPanel(new GridLayout());
        preenchimentInf.add(painelcontem);  

        // Criando um painel dentro de preenchimentoInf para conter os componentes
        JPanel meio = new JPanel(new GridLayout(4, 1));
        painelcontem.add(meio);

        JPanel compoIdade = new JPanel(new GridLayout(2,1));
        JPanel compoPeso = new JPanel(new GridLayout(2, 1));
        JPanel compoAltura = new JPanel(new GridLayout(2, 1));
        JPanel compoResult = new JPanel(new GridLayout(2,1));

        meio.add(compoIdade);
        meio.add(compoPeso);
        meio.add(compoAltura);
        meio.add(compoResult);

        // Variavél para demiitar o tamanho da fonte do JTextField
        int tamInpt = 50;


        /* Criando os componentes */
        JLabel textIdade = new JLabel("Idade");
        JTextField inputIdade = new JTextField("Digite sua idade aqui", tamInpt);

        JLabel textPeso = new JLabel("Peso");
        JTextField inputPeso = new JTextField("Digite seu Peso aqui", tamInpt);

        JLabel textAltura = new JLabel("Altura");
        JTextField inputAltura = new JTextField("Digite sua Altura aqui", tamInpt);

        JLabel textResult = new JLabel("Resultado");
        JTextArea resultadoApare = new JTextArea(2, 1);


        /* ADD os componentes os seus devidos paineis */
        compoIdade.add(textIdade);
        compoIdade.add(inputIdade);

        compoPeso.add(textPeso);
        compoPeso.add(inputPeso);

        compoAltura.add(textAltura);
        compoAltura.add(inputAltura);

        compoResult.add(textResult);
        compoResult.add(resultadoApare);

        // Criação de um painel para conter os elementos do SUL do BorderLayout
        JPanel fim = new JPanel();
        this.add(fim, BorderLayout.SOUTH);

        // Criação de um botão para possibilitar fazer o calculo
        JPanel botãoEnviar = new JPanel(new FlowLayout());
        fim.add(botãoEnviar);

        JButton botao = new JButton("Calcular");
        botãoEnviar.add(botao);



        /* Deixando Visivel */
        this.setVisible(true);

    }
}
