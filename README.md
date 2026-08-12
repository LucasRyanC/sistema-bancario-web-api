# 🏦 Sistema Bancário Web (API REST)

## 📖 Sobre o Projeto
Uma API RESTful desenvolvida em Java com Spring Boot para simular as operações essenciais de um sistema bancário. Este projeto foi construído com foco em boas práticas de Back-End, utilizando princípios de Orientação a Objetos e persistência de dados em um banco de dados relacional.

## 🚀 Tecnologias Utilizadas
- **Java** 
- **Spring Boot** (Web, Data JPA)
- **PostgreSQL** (Banco de Dados)
- **Maven** (Gerenciamento de dependências)

## ⚙️ Funcionalidades (CRUD)
O sistema permite o gerenciamento completo do ciclo de vida de uma conta bancária:
- `POST /contas` - Criação de uma nova conta.
- `GET /contas` - Listagem de todas as contas ativas.
- `PUT /contas/{id}/deposito/{valor}` - Operação de depósito (atualização de saldo).
- `DELETE /contas/{id}` - Encerramento e exclusão de conta.

## 🛠️ Como rodar o projeto localmente

1. Clone o repositório:
`git clone https://github.com/LucasRyanC/sistema-bancario-web-api.git`

2. Configure o seu banco de dados PostgreSQL local (crie um banco chamado `banco_lucas`).
3. Atualize o arquivo `application.properties` com o seu usuário e senha do banco.
4. Execute o projeto usando o Maven Wrapper:
`.\mvnw.cmd spring-boot:run`

A API estará disponível em `http://localhost:8080/contas`.
