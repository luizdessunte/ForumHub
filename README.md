# API ForumHub 🗣️

<p align="center">
  <img src="https://i.imgur.com/m8S1FfT.png" width="200" alt="Logo do ForumHub">
</p>

<p align="center">
  <img alt="Status do Projeto" src="https://img.shields.io/badge/STATUS-EM%20DESENVOLVIMENTO-yellow">
</p>

## 🎯 Sobre o Projeto

Bem-vindo ao **ForumHub**! Esta é uma API REST desenvolvida como parte do desafio de backend do programa **Alura ONE + Oracle Next Education**. O objetivo é construir o backend de um fórum de discussão, aplicando conceitos sólidos de arquitetura de software, segurança e boas práticas com o ecossistema Spring.

---

## ✅ Funcionalidades Implementadas

O foco inicial foi construir um CRUD robusto e funcional para o recurso principal: os **Tópicos**.

-   [x] 🚀 **Cadastrar novo tópico:** `POST /topicos`
-   [x] 📄 **Listar todos os tópicos:** `GET /topicos` (com paginação e ordenação!)
-   [x] 🔍 **Detalhar um tópico específico:** `GET /topicos/{id}`
-   [x] ✏️ **Atualizar um tópico:** `PUT /topicos/{id}`
-   [x] 🗑️ **Apagar um tópico:** `DELETE /topicos/{id}`

### 🚧 Próximos Passos

-   [ ] 🔐 **Segurança:** Implementar autenticação e autorização com Tokens JWT.
-   [ ] 🛡️ **Validações:** Adicionar tratamento de erros e validações de negócio avançadas.
-   [ ] 📖 **Documentação:** Gerar documentação da API com Swagger/OpenAPI.

---

## 🔌 API Endpoints

| Verbo HTTP | Endpoint              | Descrição                                         |
|------------|-----------------------|---------------------------------------------------|
| `POST`     | `/topicos`            | Cadastra um novo tópico.                          |
| `GET`      | `/topicos`            | Lista todos os tópicos (paginado e ordenado).     |
| `GET`      | `/topicos/{id}`       | Detalha um tópico específico.                     |
| `PUT`      | `/topicos/{id}`       | Atualiza um tópico existente.                     |
| `DELETE`   | `/topicos/{id}`       | Apaga um tópico existente.                        |

---

## 🚀 Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

* **Java 17:** A versão LTS mais recente do Java.
* **Spring Boot 3:** Para uma configuração rápida e robusta da aplicação.
* **Spring Security:** Para a camada de segurança.
* **Spring Data JPA:** Para a persistência de dados de forma simplificada.
* **Maven:** Para a gestão de dependências e do build do projeto.
* **MySQL 8:** O nosso banco de dados relacional.
* **Flyway:** Para o versionamento e migração do banco de dados.
* **Lombok:** Para reduzir o código boilerplate.

---

## ▶️ Como Executar o Projeto

```bash
# 1. Clone o repositório
$ git clone [https://github.com/luizdessunte/ForumHub.git](https://github.com/luizdessunte/ForumHub.git)

# 2. Aceda à pasta do projeto
$ cd ForumHub

# 3. Execute a aplicação (requer Maven e Java 17 instalados)
$ mvn spring-boot:run
```
