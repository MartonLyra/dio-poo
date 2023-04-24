# POO - Programação Orientada a Obbjeto - Java 
Nesse repositório vamos demonstrar exemplos de como usar Programação Orientada a Objetos com Java


## Paradigma de Programação Orientado a Objetos

A visão de Orientação a Objetos (OO) é aquela de um mundo de objetos que interagem.
Este paradigma é um modelo de análise, projeto e programação baseado na aproximação entre o mundo real e o mundo virtual, através da criação e interação entre classes, atributos, métodos, objetos, entre outros.
São 4 os pilares principais do POO: ABSTRAÇÃO, ENCAPSULAMENTO, HERANÇA E POLIMORFISMO.


### Abstração:

É a habilidade de concentrar-se nos aspectos essenciais de um domínio, ignorando características menos importantes ou acidentais. Nesse contexto, objetos são abstrações de entidades existentes no domínio em questão.

A título de exemplo de abstração, imagine o contexto de contas bancárias onde, no nosso exemplo, teremos 3 tipos de contas: ContaPoupança, ContaCorrente e ContaInvestimento.

Como é de imaginar, cada uma das 3 contas possui regras diferentes para um mesmo ato: sacar. Vamos supor as seguintes regras:

- Conta Poupança: para sacar, simplesmente verifica se há saldo e, havendo, realiza o saque. Não havento saldo, lançamos exceção de Saldo Insuficiente.
- Conta Corrente: nesse caso, a conta pode ter um limite pré-autorizado. Portanto, caso não haja saldo, vamos consultar se há limite pré-autorizado e, caso positivo, se o valor do saque está dentro do saldo + limite pré-autorizado.
- Conta Investimento: já a regra aqui é, se a conta estiver configurada para "baixa automática do investimento", na hora do saque, se não houver saldo em conta, se a opção de "baixa automática" estiver ativa, iremos consultar o valor investido. Caso haja valor investido e seja suficiente, será feito a baixa e, em seguida o saque. Do contrário, lançamos exceção de Saldo Insuficiente.

No exemplo acima, abstração é poder realizar o saque informando apenas o valor do saque sem se preocupar com as regras específicas de cada tipo de conta. Cada conta tem sua regra de negócio específica para o mesmo ato, sacar; Ou seja, estamos abstraindo da classe 'Conta', o código que realizará o saque.

### Encapsulamento:

Encapsular significa esconder a implementação dos objetos. O encapsulamento favorece principalmente dois aspectos de um sistema: a manutenção e a evolução.

No código exemplo, das contas, imagine que um programador desatento realize as seguintes operações:  


    conta.sacarDaConta(1000);  
    conta.saldoConta = 1000;  
    
    conta.sacarDaConta(1000);  
    conta.saldoConta = 1000;  
    
    conta.sacarDaConta(1000);  
    conta.saldoConta = 1000;  


No exemplo acima, se a propriedade saldoConta não estiver protegida pelo encapsulamento, ele pode realizar as operações acima sem problema. Mas, no momento em que mudamos 'saldoConta' para 'private' ou 'protected', o desenvolvedor precisará usar um dos demais métodos para realizar a operação e, consequentemente, manter a integridade dos dados do sistema.

