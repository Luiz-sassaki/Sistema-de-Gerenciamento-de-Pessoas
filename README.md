# Sistema de Gerenciamento de Pessoas - Universidade

Este projeto é uma API simples para o sistema de gerenciamento de pessoas de uma universidade. A API permite criar, consultar, atualizar e deletar pessoas no sistema, com base de dados em MySQL.

## Integrantes do Grupo:
Gabriel Augusto Ferreira

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Lombok
- **Banco de dados**: MySQL

## Requisitos do Projeto

1. **Entidade Pessoa**:
   - A aplicação possui uma entidade `Pessoa` que contém os campos: 
     - `nome` (String)
     - `cpf` (String)
     - `idade` (Integer)

2. **Banco de Dados**:
   - O banco de dados utilizado é o **MySQL**.
   - As variáveis de conexão devem ser configuradas conforme as seguintes propriedades:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/nome_da_base
     spring.datasource.username=root
     spring.datasource.password=senha
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
     ```

3. **Endpoints da API**:
   - A API expõe dois endpoints principais para criação e consulta de pessoas.

   - **POST** `/api/v1/pessoas/salvar`
     - Cria uma nova pessoa no banco de dados.
     - Exemplo de request body:
       ```json
       {
         "nome": "João Silva",
         "cpf": "123.456.789-00",
         "idade": 25
       }
       ```
     - Exemplo de resposta:
       ```json
       {
         "id": "d290f1ee-6c54-4b01-90e6-d701748f0851",
         "nome": "João Silva",
         "cpf": "123.456.789-00",
         "idade": 25
       }
       ```

   - **GET** `/api/v1/pessoas/{id}`
     - Retorna uma pessoa com o `id` especificado.
     - Exemplo de resposta:
       ```json
       {
         "id": "d290f1ee-6c54-4b01-90e6-d701748f0851",
         "nome": "João Silva",
         "cpf": "123.456.789-00",
         "idade": 25
       }
       ```

## Como Executar o Projeto

### Pré-requisitos

- **Java 17+**
- **MySQL** rodando localmente ou em um servidor.
- **Maven** instalado.

### Configuração do Banco de Dados

1. Crie um banco de dados MySQL com o nome de sua escolha (por exemplo, `nome_da_base`).
2. Atualize o arquivo `application.properties` com suas credenciais de banco de dados:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nome_da_base
   spring.datasource.username=root
   spring.datasource.password=senha
