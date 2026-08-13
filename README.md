# 🏦 Sistema Bancário Web API

Uma API RESTful desenvolvida em Java com Spring Boot, focada em simular operações essenciais de um sistema bancário. O projeto foi construído seguindo rigorosamente as melhores práticas do mercado corporativo, incluindo Arquitetura em 3 Camadas e Tratamento Global de Exceções.

---

## Tecnologias Utilizadas

- **Linguagem:** Java (JDK 21)
- **Framework:** Spring Boot 3
- **Banco de Dados:** PostgreSQL
- **Persistência:** Spring Data JPA / Hibernate
- **Testes de API:** Postman

---

## Arquitetura e Padrões

O projeto foi estruturado seguindo o padrão de **Arquitetura em 3 Camadas** para garantir a separação de responsabilidades e facilitar a escala do código:

- **Controller:** Gerencia as requisições HTTP e roteamento.
- **Service:** Centraliza as regras de negócio e validações (ex: bloqueio de depósitos negativos).
- **Repository:** Responsável pela comunicação direta com o banco de dados PostgreSQL.

A API também conta com um **GlobalExceptionHandler** (`@RestControllerAdvice`), garantindo que erros internos do servidor (Stack Traces) não sejam expostos e que o cliente receba respostas HTTP limpas e padronizadas (como `400 Bad Request` e `404 Not Found`).

---

## Como Executar o Projeto

1. Certifique-se de ter o **Java 21** e o **PostgreSQL** instalados na sua máquina local.
2. Crie um banco de dados no PostgreSQL chamado `banco_lucas` (ou atualize as credenciais de acesso no arquivo `application.properties`).
3. Clone este repositório.
4. Abra o terminal na raiz do projeto e execute o comando do Maven:

   ```bash
   .\mvnw.cmd spring-boot:run

    O servidor iniciará localmente na porta 8080.
   ```

Como Testar a API

Para interagir com a aplicação, utilize um API Client como Postman ou Insomnia realizando requisições para http://localhost:8080.

Rotas Disponíveis:

    POST /contas - Cria uma nova conta no banco de dados.

    GET /contas - Lista todas as contas cadastradas.

    PUT /contas/{id}/deposito/{valor} - Realiza um depósito (com validação de valor > 0).

    DELETE /contas/{id} - Exclui uma conta existente.

Exemplo de Corpo da Requisição (POST /contas):
JSON

{
"titular": "Lucas Ryan",
"saldo": 1500.0
}
