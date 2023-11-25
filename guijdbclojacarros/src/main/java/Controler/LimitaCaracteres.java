package Controler;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument; //Esta classe é responsável por suportar a edição de documentos grandes com eficiência.

//Limita os inputs para receberem tipos expecificos de dados
public class LimitaCaracteres extends PlainDocument {

    // enumerador para organizar o tipo de dado que deseja aparecer
    public enum TipoEntrada {
        MARCA, MODELO, ANO, PLACA, VALOR, NOME, CPF, DATANASC, TELEFONE, ENDERECO;
    }

    // Atributos
    private int qtdCaracteres;
    private TipoEntrada tpEntrada;

    public LimitaCaracteres(int qtdCaracteres, TipoEntrada tpEntrada) {
        this.qtdCaracteres = qtdCaracteres;
        this.tpEntrada = tpEntrada; // Atribui o enumerador ao meu construtor
    }

    // E
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        // Criando teste para caso caracterDigi> qtdCarateres ela ja saía do metodo
        // automaticamete
        if (str == null || getLength() == qtdCaracteres) {
            return;
        }

        // Cria variavel para armazenar todos os caracteres e tambem as palavras
        // digitadas
        int totalCarac = getLength() + str.length();

        // Filtragem dos dados
        // String para armazenar os filtros
        String recebfilt = "";
        switch (tpEntrada) {
            case
                    // Exluir tudo exceto(simbolo = ^) o que estiver no meu delimitador(recebfilt);
                    MARCA:
                recebfilt = "[^\\p{IsLatin} ]"; // p{IsLatin} significa: qualquer caractere de escrita latina. //FORD
                break;
            case
                    MODELO:
                recebfilt = "[^\\p{IsLatin} 0-9\\-]"; // Para aceitar o - é preciso utilizar \\F-1000
                break;
            case
                    ANO:
                recebfilt = "[^0-9]"; // 2000
                break;
            case
                    PLACA:
                recebfilt = "[^\\p{IsLatin}\\-0-9]"; // FOR-123
                break;
            case
                    VALOR:
                recebfilt = "[^0-9]"; // 30000
                break;
            case
                    NOME:
                recebfilt = "[^\\p{IsLatin} ]"; // Heitor
                break;
            case
                    CPF:
                recebfilt = "[^\\p{IsLatin}\\-0-9/]"; // 123.123.123/12
                break;
            case
                    DATANASC:
                recebfilt = "[^0-9/.]"; // 12/12/1212
                break;
            case
                    TELEFONE:
                recebfilt = "[^()0-9 \\-]"; // (019) 99999-9999
                break;
            case
                    ENDERECO:
                recebfilt = "[^\\p{IsLatin} 0-9.\\-]"; // R. Rua1 JD. Bairro2 - 123
                break;
        }

        // Fazendo a substituição dos dados que não estiverem de acordo com os
        // parametros acima
        str = str.replaceAll(recebfilt, ""); // Substitui os caracteres que estão contidos na minha str excetos os
                                             // recebfilt por vazio("")

        // Limitando a quantidade de caracteres digitado
        if (totalCarac <= qtdCaracteres) {
            // Modifica o corpo
            super.insertString(offs, str, a); // Deve ser chamado apos a string ja estar formatada
        } else {
            String nova = str.substring(0, qtdCaracteres);
            super.insertString(offs, nova, a);
        }
    }
}
