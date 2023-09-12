RELATÓRIO ATIVIDADE LAYOUT 12/09/2023

HEITOR E JOÃO LIMA

Tipos de Layout:
    BorderLayout:
        O BorderLayout é normalmente usado para demilitar onde os paineis com os componentes serão alocados, seu funcionamento é dado pela divisão da janela/painel em cinco areas (NORTH,SOUTH,WEST,EAST e CENTER). Nós a utilizamos nas seguintes calculadoras: combustível, IMC e Padrão, sendo necessária para a distribuição e a organização dos componentes.  
            COMO UTILIZAR:
                
                De inicio devemos atribuir seu layout a um JPanel ou JFrame:
                    JPanel painel = new JPanel(new BorderLayout()); // Aqui criamos um obj da classe Jpanel e nela propria atribuímos um novo layout, no caso BORDERLAYOUT.
                    this.add(painel);  //Aqui add painel a janela principal.

                Em seguida ao adicionar um componente colocamos "," e em seguida chamamos a classe BorderLayout e chamamos o método de sua posição(posição dada pelos pontos cardiais) EX:(NORTH,SOUTH,WEST,EAST ou CENTER):
                    painel.add(new JTextPane(), BorderLayout.NORTH);
    GridLayout:
        O GridLayout é muito utilizado na maioria das aplicações, seu funcionamento pode ser dado pela delimitação de linhas e colunas, sendo possivel criar layouts diferenciados. Ele preenche o espaço delimitado redmensionando o tamanho dos componentes 
    FlowLayout:

    GridBag:
    