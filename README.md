# API ForumHub 🗣️

<p align="center">
  <img alt="ForumHub Logo" src="https://raw.githubusercontent.com/luizdessunte/ForumHub/main/src/main/resources/static/images/logo.png" width="200">
</p>

<p align="center">
  <img alt="Status do Projeto" src="https://img.shields.io/badge/STATUS-EM%20DESENVOLVIMENTO-yellow">
</p>

## 🎯 Sobre o Projeto

Bem-vindo ao **ForumHub**! Esta é uma API REST desenvolvida como parte do desafio de backend do programa **Alura ONE + Oracle Next Education**. O objetivo é construir o backend de um fórum de discussão, aplicando conceitos sólidos de arquitetura de software, segurança e boas práticas com o ecossistema Spring.

---

## ✅ Funcionalidades Implementadas

O foco inicial foi construir um CRUD robusto e funcional para o recurso principal: os **Tópicos**.

- Listar todos os tópicos com paginação.
- Detalhar um tópico específico.
- Atualizar um tópico.
- Apagar um tópico.

---

## 🚧 Funcionalidades Extras em Desenvolvimento

Além dos tópicos, novas rotas estão sendo implementadas para tornar o fórum ainda mais completo:

- [ ] **Usuários** (`/usuario`): Cadastro, listagem, atualização e exclusão de usuários.
- [ ] **Respostas** (`/respostas`): Cadastro, listagem, atualização e exclusão de respostas aos tópicos.
- [ ] **Tratamento de Erros**: Implementação de respostas padronizadas para erros de validação, autenticação e exceções da API.

Essas funcionalidades estão em desenvolvimento e serão lançadas em breve.

---

## 🧑‍💻 API Endpoints

| Verbo HTTP | Endpoint         | Descrição                                              | Acesso     |
|------------|------------------|--------------------------------------------------------|------------|
| `POST`     | `/login`         | Autentica um utilizador e devolve um token JWT.        | **Público**|
| `POST`     | `/topicos`       | Cadastra um novo tópico.                               | Protegido  |
| `GET`      | `/topicos`       | Lista todos os tópicos (paginado e ordenado).          | Protegido  |
| `GET`      | `/topicos/{id}`  | Detalha um tópico específico.                          | Protegido  |
| `PUT`      | `/topicos/{id}`  | Atualiza um tópico existente.                          | Protegido  |
| `DELETE`   | `/topicos/{id}`  | Apaga um tópico existente.                             | Protegido  |

---

## 🚀 Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

- **Java 17:** A versão LTS mais recente do Java.
- **Spring Boot 3:** Para uma configuração rápida e robusta da aplicação.
- **Spring Security:** Para a camada de segurança.
- **Spring Data JPA:** Para a persistência de dados de forma simplificada.
- **Maven:** Para a gestão de dependências e do build do projeto.
- **MySQL 8:** O nosso banco de dados relacional.
- **Flyway:** Para o versionamento e migração do banco de dados.
- **Lombok:** Para reduzir o código boilerplate.

---

## ▶️ Como Executar o Projeto

```bash
# 1. Clone o repositório
$ git clone https://github.com/luizdessunte/ForumHub.git

# 2. Acesse a pasta do projeto
$ cd ForumHub

# 3. Configure as suas variáveis de ambiente
# No arquivo `application.properties`, altere as seguintes linhas com os seus dados:
# spring.datasource.username=SEU_USUARIO_MYSQL
# spring.datasource.password=SUA_SENHA_MYSQL
# api.security.token.secret=SUA_CHAVE_SECRETA_PARA_JWT

# 4. Execute a aplicação (requer Maven e Java 17 instalados)
$ mvn spring-boot:run
```

A API estará disponível em http://localhost:8080.

---

## 👨‍💻 Autor
Desenvolvido por Luiz Dessunte.

<p>
  <a href="https://www.linkedin.com/in/luiz-dessunte/" target="_blank" style="text-decoration:none;">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/linkedin/linkedin-original.svg" width="30" height="30" alt="LinkedIn" style="vertical-align:middle;"/>
    <span style="vertical-align:middle; margin-left: 8px; font-weight: bold; color: #0A66C2;">LinkedIn</span>
  </a>
  &nbsp;&nbsp;
  <a href="https://github.com/luizdessunte" target="_blank" style="text-decoration:none;">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="30" height="30" alt="GitHub" style="vertical-align:middle;"/>
    <span style="vertical-align:middle; margin-left: 8px; font-weight: bold; color: #333;">GitHub</span>
  </a>
</p>
