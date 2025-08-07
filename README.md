# API ForumHub 🗣️

<p align="center">
  <img alt="Status do Projeto" src="https://img.shields.io/badge/STATUS-CONCLUÍDO-brightgreen">
</p>

## 🎯 Sobre o Projeto

Bem-vindo ao **ForumHub**! Esta é uma API REST desenvolvida como o desafio final de backend do programa **Alura ONE + Oracle Next Education (ONE)**. O objetivo foi construir um sistema de controle de tópicos para um fórum, aplicando os conceitos mais importantes do desenvolvimento backend com o ecossistema Spring.

---

## ✅ Funcionalidades Implementadas

-   [x] 🔐 **Segurança:** Sistema de login e registro com geração de token JWT.
-   [x] 🛡️ **Controle de Acesso:** Endpoints protegidos, exigindo um token de autenticação válido.
-   [x] 📄 **Gestão de Tópicos:** CRUD completo com exclusão lógica.
-   [x] 💬 **Gestão de Respostas:** CRUD completo para as respostas dos tópicos.
-   [x] ⚙️ **Tratamento de Erros:** Respostas de erro padronizadas para todos os cenários.
-   [x] 📖 **Documentação:** Interface interativa da API gerada com Swagger (OpenAPI).
-   [x] 👑 **Sistema de Permissões (Roles):** Diferenciação de permissões entre usuários (`USER`) e administradores (`ADMIN`), protegendo endpoints de modificação e exclusão.

---

## 🚧 Próximos Passos

-   [ ] **Testes Automatizados:** Expandir a cobertura de testes para todos os endpoints.

---

## 🔌 API Endpoints

| Verbo HTTP | Endpoint                  | Descrição                                         | Acesso       |
|------------|---------------------------|---------------------------------------------------|--------------|
| `POST`     | `/login`                  | Autentica um usuário e devolve um token JWT.      | **Público** |
| `POST`     | `/usuarios/registrar`     | Registra um novo usuário no sistema.              | **Público** |
| `POST`     | `/topicos`                | Cadastra um novo tópico.                          | **Protegido**|
| `GET`      | `/topicos`                | Lista todos os tópicos ativos (paginado).         | **Protegido**|
| `GET`      | `/topicos/{id}`           | Detalha um tópico específico.                     | **Protegido**|
| `PUT`      | `/topicos/{id}`           | Atualiza um tópico existente.                     | **Protegido (Autor ou Admin)**|
| `DELETE`   | `/topicos/{id}`           | Apaga um tópico (exclusão lógica).                | **Protegido (Autor ou Admin)**|
| `POST`     | `/respostas`              | Cadastra uma nova resposta a um tópico.           | **Protegido**|
| `GET`      | `/respostas/topico/{idTopico}` | Lista todas as respostas de um tópico.           | **Protegido**|
| `PUT`      | `/respostas/{id}`         | Atualiza uma resposta existente.                  | **Protegido (Autor ou Admin)**|
| `DELETE`   | `/respostas/{id}`         | Apaga uma resposta existente.                     | **Protegido (Autor ou Admin)**|

---

## 🚀 Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

* ![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white) **Java 17**: A versão LTS mais recente do Java.
* ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white) **Spring Boot 3**: Para uma configuração rápida e robusta da aplicação.
* ![Spring Security](https://img.shields.io/badge/Spring%20Security-6-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white) **Spring Security**: Para a camada de segurança e autenticação.
* ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3-6DB33F?style=for-the-badge&logo=spring&logoColor=white) **Spring Data JPA**: Para a persistência de dados de forma simplificada.
* ![JWT](https://img.shields.io/badge/JWT-JSON%20Web%20Token-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white) **JWT**: Para a geração de tokens de acesso.
* ![Maven](https://img.shields.io/badge/Maven-4-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white) **Maven**: Para a gestão de dependências e do build do projeto.
* ![MySQL](https://img.shields.io/badge/MySQL-8-4479A1?style=for-the-badge&logo=mysql&logoColor=white) **MySQL 8**: O nosso banco de dados relacional.
* ![Flyway](https://img.shields.io/badge/Flyway-10-CC0200?style=for-the-badge&logo=flyway&logoColor=white) **Flyway**: Para o versionamento e migração do banco de dados.
* ![Lombok](https://img.shields.io/badge/Lombok-1.18-000000?style=for-the-badge&logo=lombok&logoColor=white) **Lombok**: Para reduzir o código boilerplate.
* ![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black) **SpringDoc OpenAPI (Swagger)**: Para a documentação automática da API.

---

## ▶️ Como Executar o Projeto

```bash
# 1. Clone o repositório
$ git clone https://github.com/luizdessunte/ForumHub.git

# 2. Navegue até o diretório do projeto
$ cd forumHub


# 3. Configure as suas variáveis de ambiente no ficheiro `application.properties`
#    **IMPORTANTE:** Estas informações são sensíveis e não devem ser enviadas para o GitHub.
#    O ficheiro `.gitignore` já está configurado para ignorar ficheiros de configuração locais.
#
#    Altere as seguintes linhas com os seus dados:
#    spring.datasource.username=SEU_USUARIO_MYSQL
#    spring.datasource.password=SUA_SENHA_MYSQL
#    api.security.token.secret=SUA_CHAVE_SECRETA_PARA_JWT

# 4. Inicie a aplicação (requer Maven e Java 17 instalados)
$ mvn spring-boot:run

# 4. Execute as migrações do banco de dados com Flyway
$ mvn flyway:migrate

# 5. Inicie a aplicação (requer Maven e Java 17 instalados)
$ mvn spring-boot:run
```

A API estará disponível em http://localhost:8080.

A documentação do Swagger estará disponível em http://localhost:8080/swagger-ui.html.

👨‍💻 Autor:
Desenvolvido por Henrique Dessunte
<p align="left">
<a href="https://www.linkedin.com/in/luiz-dessunte/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"/>
</a>
<a href="https://github.com/luizdessunte" target="_blank">
<img src="https://img.shields.io/badge/-GitHub-181717?style=for-the-badge&logo=github&logoColor=white" alt="GitHub"/>
</a>
</p>