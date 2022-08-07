# CRUD Java API

Uma REST API Java para gerenciamento de bancos de dados. Desafio de projeto para **Santander Bootcamp Fullstack Developer** na [Digital Innovation One](https://www.dio.me).

## Funcionalidades
- :chart: Métodos criar, ler, atualizar e remover.
- :chart: Senhas criptografadas.
- :chart: Validação de e-mails únicos.

## Documentação
- [Instalação](#Instalação)
- [Como usar](#Endpoints)
- [Tecnologias](#Métodos)

## Instalação
> Acesse [aqui](https://crud-java-api.herokuapp.com) a versão na nuvem.

## Como usar
Todos as requisições devem ser feitas a **[https://crud-java-api.herokuapp.com/customers](https://crud-java-api.herokuapp.com/customers)** enviando dados em formato **JSON** no seguinte padrão:

```bash
{ "name": "nome", "email": "email", "password": "senha" }
```

## Endpoints

 - **GET /customers**

> Retorna todos os usuários salvos no banco de dados.
 
 - **GET /customers/:id**

> Retorna o usuário com o id referente ao id enviado como parâmetro.

 - **POST /customers**

> Cria um novo usuário, caso não exista no banco de dados.

 - **PUT /customers/:id**

> Atualiza os dados do usuário com o id referente ao id enviado como parâmetro, de acordo com as informações enviadas no payload.

 - **DELETE /customers/:id**
> Remove o usuário com o id referente ao id enviado como parâmetro, caso exista no banco de dados.


## Tecnologias
Ferramentas utilizadas durante o desenvolvimento:

- [H2 Database](https://www.h2database.com/html/main.html)
- [Java JDK 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- Spring Web
