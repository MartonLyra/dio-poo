# POO - Programação Orientada a Objeto - Java 
[Nesse repositório](https://github.com/MartonLyra/dio-poo) vamos demonstrar exemplos de como usar Programação Orientada a Objetos com Java


## Paradigma de Programação Orientado a Objetos

A visão de Orientação a Objetos (OO) é aquela de um mundo de objetos que interagem.  

Este paradigma é um modelo de análise, projeto e programação baseado na aproximação entre o mundo real e o mundo virtual, através da criação e interação entre classes, atributos, métodos, objetos, entre outros.  

São 4 os pilares principais do POO: ABSTRAÇÃO, ENCAPSULAMENTO, HERANÇA E POLIMORFISMO.

### Abstração:

É a habilidade de concentrar-se nos aspectos essenciais de um domínio, ignorando características menos importantes ou acidentais. Nesse contexto, objetos são abstrações de entidades existentes no domínio em questão.

A título de exemplo de abstração, imagine o contexto de contas bancárias onde, no nosso exemplo, teremos 3 tipos de contas: [ContaPoupança](src/desafio/poo/ContaPoupanca.java), [ContaCorrente](src/desafio/poo/ContaCorrente.java) e [ContaInvestimento](src/desafio/poo/ContaInvestimento.java).

Como é de imaginar, cada uma das 3 contas possui regras diferentes para um mesmo ato: sacar. Vamos supor as seguintes regras:


- [Conta Poupança](src/desafio/poo/ContaPoupanca.java): para sacar, simplesmente verifica se há saldo e, havendo, realiza o saque. Não havendo saldo, lançamos exceção de Saldo Insuficiente.


- [Conta Corrente](src/desafio/poo/ContaCorrente.java): nesse caso, a conta pode ter um limite pré-autorizado. Portanto, caso não haja saldo, vamos consultar se há limite pré-autorizado e, caso positivo, se o valor do saque está dentro do saldo + limite pré-autorizado.


- [Conta Investimento](src/desafio/poo/ContaInvestimento.java): a Conta de Investimento herda de conta corrente, ou seja, também pode possuir um limite pré-aprovado. Além disso, há o saldo investido. Sendo assim, a regra do saque é: se a conta estiver configurada para "baixa automática do investimento" e não houver saldo em conta iremos consultar o valor investido. Caso haja valor investido e seja suficiente, será feito a baixa e, em seguida, vamos chamar o saque da ContaCorrente. Do contrário, lançamos exceção de Saldo Insuficiente.  


No exemplo acima, abstração é poder realizar o saque informando apenas o valor do saque sem se preocupar com as regras específicas de cada tipo de conta. Cada conta tem sua regra de negócio específica para o mesmo ato, sacar; Ou seja, estamos abstraindo da classe 'Conta', o código que realizará o saque.

### Encapsulamento:

Encapsular significa esconder a implementação dos objetos. O encapsulamento favorece principalmente dois aspectos de um sistema: a manutenção e a evolução.

No código exemplo, das contas, imagine que um programador desatento realize as seguintes operações:  


    contaOrigem.saldoConta += 1000;    
    Conta.transferir(contaOrigem, contaDestino, 1000);
    contaDestino.sacarDaConta(1000);

    contaOrigem.saldoConta += 1000;    
    Conta.transferir(contaOrigem, contaDestino, 1000);
    contaDestino.sacarDaConta(1000);  



No exemplo acima, se a propriedade **Conta.saldoConta** não estiver protegida pelo encapsulamento, ele pode realizar as operações sem problema para aumentar o saldo da conta sem autorização.  

Mas, quando mudamos 'saldoConta' para 'private' ou 'protected', o desenvolvedor não mais terá acesso direto a propriedade saldoConta e precisará usar um dos demais métodos, com suas respectivas regras de negócio, para realizar a operação e, consequentemente, manter a integridade dos dados do sistema.

### Herança:

Permite que você defina uma classe filha que reutiliza (herda), estende ou modifica o comportamento de uma classe pai. A classe cujos membros são herdados é chamada de classe base. A classe que herda os membros da classe base é chamada de classe derivada.

No nosso exemplo, a [Conta de Investimento](src/desafio/poo/ContaInvestimento.java) herda da [Conta Corrente](src/desafio/poo/ContaCorrente.java). Ou seja, possui várias características de Conta Corrente que não precisam ser reimplementadas como, por exemplo, ter um limite pré-aprovado.

Porém, também pode ter valores investidos. Com isso, temos os novos métodos **investir()** e **sacarInvestimento()**.

Outro detalhe importante é para o método sacarDaConta(), a regra agora é: caso não haja saldo suficiente, antes de usar o limite, se o cliente optou pela "Baixa automática de investimento", então será feito a baixa do investimento e, apenas o valor remanescente, se necessário, usará do limite da conta.


### Polimorfismo:

É Capacidade de um objeto poder ser referenciado de várias formas. Cuidado, polimorfismo não quer dizer que o objeto fica se transformando, muito pelo contrário, um objeto nasce de um tipo e morre daquele tipo, o que pode mudar é a maneira como nos referimos a ele. A capacidade de tratar objetos criados a partir das classes específicas como objetos de uma classe genérica é chamada de polimorfismo.

Observe que a classe **[Conta](src/desafio/poo/Conta.java)** possui um método estático **transferir(),** que recebe três parâmetros: a **conta de origem**, a **conta de destino** e o **valor da transferência**:

    public static void transferir (Conta contaOrigem, Conta contaDestino, double valorTransferencia);

Nosso método **transferir** vai chamar o método **sacarDaConta** da conta de origem. E observe que o método **transferir** não precisa conhecer quantos tipos de conta existem (poupança, corrente, investimento) assim como não precisa chamar suas respectivas regras de negócio de cada tipo de conta. Basta chamar o método **sacarDaConta** e, a depender do objeto instanciado que implementa [Conta](src/desafio/poo/Conta.java), esse objeto vai agir conforme suas regras de saque.  

Por fim, o método **transferir** vai chamar o método depositar da conta de destino, para concluir a transferência.  

  
  
  
Base64: RGVzYWZpbyBEaW8ubWUsICJQcm9ncmFtYcOnw6NvIE9yaWdlbnRhZGEgYSBPYmpldG9zIiwgY29uY2x1w61kbyBwb3IgTWFydG9uIEx5cmEgZW0gMjQvMDQvMjAyMw==