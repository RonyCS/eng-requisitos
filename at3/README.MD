Aluno: Rony Cavalcanti da Silva - 01646533
# Reflexão e Discussão

### 1. Quais desafios você encontrou ao testar os métodos?

Um dos desafios encontrados foi a necessidade de sobrescrever os métodos `equals` e `hashCode` ao comparar duas instâncias da classe `Product`. Isso não era algo que eu esperava inicialmente, mas fez total sentido depois que implementei, pois essas implementações são essenciais para garantir que as comparações entre objetos da classe sejam feitas corretamente, com base em suas propriedades, e não apenas em suas referências na memória.

### 2. Houve alguma funcionalidade que precisou ser ajustada após criar os testes? Por quê?

Sim, como mencionado anteriormente, precisei sobrescrever os métodos `equals` e `hashCode` na classe `Product`. Durante a execução dos testes, a comparação entre as instâncias da classe estava sendo feita com base nas referências de memória, o que resultava em falhas nos testes. O que eu realmente precisava era comparar as propriedades dos objetos e verificar se eles representavam os mesmos produtos. Com a sobrescrita desses métodos, a comparação passou a ser feita da forma correta.

### 3. Como os testes ajudam a garantir a qualidade do software em cenários reais?

Os testes são fundamentais para garantir a qualidade do software em diferentes fases do seu ciclo de vida. Primeiro, eles asseguram que as funcionalidades atendem aos requisitos definidos. Segundo, ajudam na detecção precoce de erros ao adicionar novas funcionalidades. E, finalmente, garantem que, ao realizar o deploy da aplicação, as funcionalidades existentes continuam funcionando corretamente. Em resumo, os testes funcionam como um "pedágio", garantindo que, ao longo de todo o ciclo de vida da aplicação, ela execute o que é esperado dela de maneira confiável e correta.
