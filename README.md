#  Sistema Bancário Web API

Uma API RESTful desenvolvida em Java com Spring Boot, focada em simular operações essenciais de um sistema bancário. O projeto evoluiu para uma arquitetura robusta de nível corporativo, incluindo segurança avançada, testes automatizados e tratamento global de exceções.

---

##  Tecnologias Utilizadas

- **Linguagem:** Java (JDK 21)
- **Framework Principal:** Spring Boot 3
- **Segurança:** Spring Security & JWT (Auth0)
- **Testes Automatizados:** JUnit 5 & Mockito
- **Banco de Dados:** PostgreSQL
- **Persistência:** Spring Data JPA / Hibernate
- **Testes de API:** Postman

---

##  Arquitetura e Padrões

O projeto foi estruturado seguindo rigorosamente as melhores práticas do mercado:

- **Arquitetura em 3 Camadas:** Separação clara entre `Controller` (Roteamento), `Service` (Regras de Negócio) e `Repository` (Banco de Dados).
- **Segurança (Stateless):** Autenticação e autorização gerenciadas por **Tokens JWT**. Senhas dos usuários são protegidas no banco de dados utilizando criptografia **BCrypt**.
- **Testes Unitários:** Cobertura de testes automatizados para as regras de negócio financeiras, utilizando o padrão **AAA (Arrange, Act, Assert)** e **Mockito** para isolamento de infraestrutura.
- **Tratamento de Exceções:** Implementação de um `GlobalExceptionHandler` (`@RestControllerAdvice`) para interceptar erros e devolver respostas HTTP limpas (como `400 Bad Request` e `404 Not Found`).

---

##  Como Executar o Projeto

1. Certifique-se de ter o **Java 21** e o **PostgreSQL** instalados na sua máquina local.
2. Crie um banco de dados no PostgreSQL chamado `banco_lucas` (ou atualize as credenciais de acesso no arquivo `application.properties`).
3. Clone este repositório.
4. Abra o terminal na raiz do projeto e execute o comando do Maven:

   ```bash
   .\mvnw.cmd spring-boot:run

    O servidor iniciará localmente na porta 8080. As tabelas (incluindo a de usuarios e contas) serão geradas automaticamente pelo Hibernate.

 Como Testar a API

Para interagir com a aplicação, utilize um API Client como Postman ou Insomnia.
Aviso: Devido à implementação do Spring Security, rotas financeiras exigem um Token JWT válido no cabeçalho (Header) da requisição (Authorization: Bearer <token>).

Principais Rotas Disponíveis:

    POST /login - Autentica o usuário e devolve o Token JWT.

    POST /contas - Cria uma nova conta no banco de dados.

    GET /contas - Lista todas as contas cadastradas.

    PUT /contas/{id}/deposito/{valor} - Realiza um depósito (com validação de valor e testes unitários).

    PUT /contas/{id}/saque/{valor} - Realiza um saque (com validação de saldo insuficiente).

    DELETE /contas/{id} - Exclui uma conta existente.
