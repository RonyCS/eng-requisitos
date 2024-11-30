Aluno: Rony Cavalcanti da Silva - 01646533
# Perguntas e Respostas

### 1. Qual foi o maior desafio ao implementar os testes?

- **Tempo para implementar**: Encontrar tempo para implementar os testes foi o maior desafio, especialmente devido à necessidade de realizar outras tarefas no dia a dia. Muitas vezes, os testes são desvalorizados, pois muitas pessoas acreditam que sua ausência não afeta diretamente o produto final.
- **Identificação de casos de falha**: Outro desafio foi identificar todos (ou a maior parte) dos casos possíveis de falha nas funções, garantindo que os testes cobrissem uma gama ampla de situações.

### 2. Algum erro foi identificado ao criar os testes? Como ele foi corrigido?

- O único erro identificado foi a falta de algumas validações nos testes, o que causava falhas ao receber parâmetros vazios. Isso foi corrigido com a adição de validações para garantir que o código retornasse listas ou valores padrões nesses casos, evitando falhas inesperadas.

### 3. Em sua opinião, quais as vantagens e limitações do uso de testes unitários em sistemas como este?

- **Vantagens**:
  - Garantia de que as funcionalidades estão funcionando como esperado.
  - Verificação se as funcionalidades atendem aos requisitos levantados.
  - Redução do retrabalho em funcionalidades incompletas ou com erros.
  - Facilidade para detectar falhas de forma precoce no desenvolvimento.

- **Limitações**:
  - **Falta de tempo**: A implementação de testes é frequentemente sacrificada devido à pressão de outras tarefas no projeto.
  - **Desvalorização por lideranças técnicas**: Em alguns casos, a importância dos testes é minimizada pela equipe de liderança técnica.
  - **Cobertura limitada**: Testes unitários verificam apenas as menores unidades de código e não testam a integração entre diferentes componentes do sistema.
  - **Foco excessivo em detalhes**: Em vez de focar na funcionalidade geral, muitas vezes os testes se concentram excessivamente nos detalhes da implementação.
  - **Manutenção de testes antigos**: Muitas vezes falta tempo para reescrever ou atualizar testes antigos, o que pode levar a uma cobertura deficiente ou desatualizada.

