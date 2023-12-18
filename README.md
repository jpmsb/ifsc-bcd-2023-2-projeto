#  Registro de progressões no movimento escoteiro: ramo lobinho

## Execução do projeto

Para executar o projeto feito em Java, basta executar o seguinte comando dentro do diretório do projeto Gradle:

```bash
./gradlew bootRun
```

## Instruções de uso

O banco de dados é povoado sempre que a aplicação é iniciada e os dados contidos anteriormente são eliminados.

O sistema conta com um menu interativo com opções de cadastro de itens e geração de relatórios. Ao executar o programa, será apresentado o menu abaixo:

```
1. Cadastro.
2. Gerar relatório.

Escolha a opção desejada (1 .. 2, 0 para sair):
```

O cenário criado inicialmente conta com uma pessoa (id 1: André Coelho Matos) com todos os requisitos para obter o Cruzeiro do Sul e uma outra pessoa (id 2: Suzanne Nadine Vega) com algumas atividades faltando:

 - Insígnia do aprender: Falta uma atividade para ganhar a insígnia
 - Especialidade culinária: Falta uma para completar o nível 3
 - Especialidade eletrônica: Possui até o nível 1
 - Distintivo lobo rastreador: Falta uma atividade para completar
 - Distintivo lobo caçador: Falta uma atividade para completar


Nos menus da aplicação, a opção 0 (zero) sempre volta para o menu anterior, com exceção do primeiro menu, onde esta opção encerra a aplicação.

### Exemplos

Para cadastrar um novo jovem, no menu principal, basta escolher a opção 1 (Cadastro). Em seguida, escolha a opção 1 (Cadastrar novo lobinho.). Serão perguntadas as informações referentes ao jovem e basta seguir as instruções na tela.

Para listar jovens que possuam determinada especialidade, basta selecionar a opção 2 (Gerar relatório.). Em seguida, selecione a opção 2 (Listar jovens com uma determinada especialidade.). Será solicitada a seleção da especialidade desejada. Por exemplo, no cenário inicial estabelecido, a especialidade "Eletrônia" (id 5) é possuída pelas seguintes pessoas:

```bash
Jovem: André Coelho Matos:
Especialidade Eletrônica (Ciência e Tecnologia): 
 - Nível 1: 4/9/2023
 - Nível 2: 7/9/2023
 - Nível 3: 10/9/2023

Jovem: Suzanne Nadine Vega:
Especialidade Eletrônica (Ciência e Tecnologia): 
 - Nível 1: 4/9/2023
``` 

Um exemplo de registro de progresso pode ser feito cadastrando-se uma especialidade para um Lobinho. Utilizando a consulta realizada anteriormente, é possível ver que a pessoa com id 2 (Suzanne Nadine Vega) não possui o nível 3 da especialidade culinária:

```
Jovem: Suzanne Nadine Vega:
Especialidade Culinária (Habilidades Escoteiras): 
 - Nível 1: 5/10/2023
 - Nível 2: 9/10/2023

Jovem: André Coelho Matos:
Especialidade Culinária (Habilidades Escoteiras): 
 - Nível 1: 5/10/2023
 - Nível 2: 9/10/2023
 - Nível 3: 13/10/2023
```

Para encontrar a atividade faltante para completar o nível 3, é possível descobrir acessando a opção 2 (Gerar relatório.) no primeiro menu. Em seguida, escolher a opção 4 (Listar os requisitos já cumpridos por um determinado jovem para uma determinada especialidade.). Na sequência, escolher o jovem que, nesse caso, será o id 2 (Suzanne Nadine Vega). Será perguntada qual especialidade deseja-se escolher, e será selecionada a especialidade "Culinária" (id 14):

```
Especialidade Culinária

1. Cozinhar para a matilha/patrulha durante 1 (um) acampamento de final de semana, a lenha e a gás, demonstrando cuidados com a segurança e a higiene.
2. Fazer uma lista dos mantimentos com quantidades necessárias para uma refeição festiva para a seção.
3. Explicar como conservar os alimentos conforme a temperatura ambiente.
4. Identificar os utensílios necessários para a preparação de uma refeição definida pelo examinador.
5. Fritar ovos e preparar saladas, decorando os pratos, e preparar uma bebida quente.
6. Preparar, em 1 (um) acampamento, 3 (três) tipos de sobremesa.
7. Preparar alguma iguaria da cozinha mateira, como pão de caçador, ovo na laranja, ovo no espeto, carne moída no espeto, etc.
8. Projetar e participar da montagem da cozinha do canto da matilha/patrulha em 1 (um) acampamento, justificando os cuidados adotados para reduzir os riscos de incêndio.
9. Preparar 1 (um) cardápio equilibrado para 1 (um) acampamento de final de semana, calculando as quantidades dos gêneros para a matilha/patrulha.
10. Abrir latas de conserva, cortar legumes e preparar uma bebida.
11. Limpar e preparar uma peça de carne e 1 (um) peixe.

Pressione ENTER para continuar...
```

Nota-se que a atividade 12 não foi registrada. Portanto, para registrá-la, se ainda estiver na mesma tela, pressione ENTER para continuar, e vá pressionando 0 (zero) até voltar ao menu inicial. No menu inicial, escolha a opção 1 (Cadastro.), em seguida, a opção 2 (Registrar progresso.). Na sequência, escolha a jovem "Suzanne Nadine Vega", opção 2. No próximo menu, escolha a opção 3 (Cadastrar progresso de especialidade.). Para este exemplo, em seguida, escolha a opção 14 (Culinária). Por fim, escolha a opção 12 (Construir uma intendência no canto de matilha/patrulha, durante 1 (um) acampamento.). Ao confirmar essa opção, será solicitado o dia, mês e ano de realização. 

Com tudo preenchido, o resultado pode ser consultado utilizando a opção 2 (Listar jovens com uma determinada especialidades.) do menu para gerar relatórios, e selecionando a especialidade 14 (Culinária):

```
Jovem: Suzanne Nadine Vega:
Especialidade Culinária (Habilidades Escoteiras): 
 - Nível 1: 5/10/2023
 - Nível 2: 9/10/2023
 - Nível 3: 10/12/2023

Jovem: André Coelho Matos:
Especialidade Culinária (Habilidades Escoteiras): 
 - Nível 1: 5/10/2023
 - Nível 2: 9/10/2023
 - Nível 3: 13/10/2023
```

## Itens implementados

- Cadastro de novos usuários, bem como associação do mesmo a um responsável já existente. O tipo sanguíneo também é exigido ser um que já esteja cadastrado.
- Cadastro de progressão para distintivo, insígnia e especialidade.
- Geração de relatório para:
  - Dados biográficos de um determinado jovem;
  - Jovens que possuem uma determinada especialidade;
  - As especialidades e insígnias de interesse especial que um determinado jovem possui;
  - Requisitos já cumpridos por um determinado jovem para uma determinada especialidade;
  
## Itens não implementados

 - Associação de um usuário a um problema de saúde no momento do cadastro;
 - Relatório de jovens que possuem todos os requisitos para obter o Cruzeiro do Sul;
 - Cadastro de participação de um jovem em um acampamento;
