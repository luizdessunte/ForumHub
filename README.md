# API ForumHub 🗣️


<p align="center">
<img alt="Status do Projeto" src="https://img.shields.io/badge/STATUS-EM%20DESENVOLVIMENTO-yellow">
</p>

## 🎯 Sobre o Projeto
Bem-vindo ao ForumHub! Esta é uma API REST desenvolvida como o desafio final de backend do programa Alura ONE + Oracle Next Education (ONE). O objetivo foi construir um sistema de controlo de tópicos para um fórum, aplicando os conceitos mais importantes do desenvolvimento backend com o ecossistema Spring.

## ✅ Funcionalidades Implementadas
- [x] 🔐 Segurança: Sistema de login (`POST /login`) e registo (`POST /usuarios/registrar`) com geração de token JWT.
- [x] 🛡️ Controlo de Acesso: Endpoints de gestão de tópicos protegidos, requerendo um token de autenticação válido no cabeçalho Authorization.
- [x] 📄 Gestão de Tópicos: CRUD completo para os tópicos do fórum.
  - Cadastrar novo tópico.
  - Listar todos os tópicos ativos com paginação.
  - Detalhar um tópico específico.
  - Atualizar um tópico.
  - Exclusão Lógica: Apagar um tópico (marcando-o como inativo).
- [x] ⚙️ Tratamento de Erros: Respostas de erro padronizadas para todos os cenários (400, 401, 403, 404, 500).
- [x] 📖 Documentação: Interface interativa da API gerada automaticamente com Swagger (OpenAPI).

## 🚧 Próximos Passos
Para evoluir ainda mais o projeto, as seguintes funcionalidades estão planejadas:
- [ ] Implementar o CRUD de Respostas: Permitir que os utilizadores respondam aos tópicos.
- [ ] Sistema de Permissões (Roles): Diferenciar permissões entre utilizadores comuns e administradores.
- [ ] Refatorar Entidades: Substituir os campos autor e curso por relacionamentos @ManyToOne com as entidades Usuario e Curso.

## 🔌 API Endpoints
| Verbo HTTP | Endpoint             | Descrição                                 | Acesso    |
|------------|---------------------|-------------------------------------------|-----------|
| POST       | /login              | Autentica um utilizador e devolve um token JWT. | Público   |
| POST       | /usuarios/registrar | Regista um novo utilizador no sistema.    | Público   |
| POST       | /topicos            | Cadastra um novo tópico.                  | Protegido |
| GET        | /topicos            | Lista todos os tópicos ativos (paginado). | Protegido |
| GET        | /topicos/{id}       | Detalha um tópico específico.             | Protegido |
| PUT        | /topicos/{id}       | Atualiza um tópico existente.             | Protegido |
| DELETE     | /topicos/{id}       | Apaga um tópico (exclusão lógica).        | Protegido |

## 🚀 Tecnologias Utilizadas
Este projeto foi construído com as seguintes tecnologias:
- <img src="https://img.shields.io/badge/Java-17-007396?logo=java&logoColor=white" alt="Java"/> Java 17: A versão LTS mais recente do Java.
- <img src="https://img.shields.io/badge/Spring_Boot-3-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot"/> Spring Boot 3: Para uma configuração rápida e robusta da aplicação.
- <img src="https://img.shields.io/badge/Spring_Security-6DB33F?logo=springsecurity&logoColor=white" alt="Spring Security"/> Spring Security: Para a camada de segurança e autenticação.
- <img src="https://img.shields.io/badge/Spring_Data_JPA-6DB33F?logo=spring&logoColor=white" alt="Spring Data JPA"/> Spring Data JPA: Para a persistência de dados de forma simplificada.
- <img src="https://img.shields.io/badge/JWT-000000?logo=jsonwebtokens&logoColor=white" alt="JWT"/> JWT (JSON Web Token): Para a geração de tokens de acesso.
- <img src="https://img.shields.io/badge/Maven-3.8.6-C71A36?logo=apachemaven&logoColor=white" alt="Maven"/> Maven: Para a gestão de dependências e do build do projeto.
- <img src="https://img.shields.io/badge/MySQL-8-4479A1?logo=mysql&logoColor=white" alt="MySQL"/> MySQL 8: O nosso banco de dados relacional.
- <img src="https://img.shields.io/badge/Flyway-11-CC0200?logo=flyway&logoColor=white" alt="Flyway"/> Flyway: Para o versionamento e migração do banco de dados.
- <img src="https://img.shields.io/badge/Lombok-1.18.24-ED6C30?logo=lombok&logoColor=white" alt="Lombok"/> Lombok: Para reduzir o código boilerplate.
- <img src="https://img.shields.io/badge/SpringDoc-OpenAPI-6DB33F?logo=openapiinitiative&logoColor=white" alt="SpringDoc OpenAPI"/> SpringDoc OpenAPI (Swagger): Para a documentação automática da API.

## ▶️ Como Executar o Projeto
```bash
# 1. Clone o repositório
$ git clone https://github.com/luizdessunte/ForumHub.git

# 2. Aceda à pasta do projeto
$ cd ForumHub

# 3. Configure as suas variáveis de ambiente
# No ficheiro `application.properties`, altere as seguintes linhas com os seus dados:
# spring.datasource.username=SEU_USUARIO_MYSQL
# spring.datasource.password=SUA_SENHA_MYSQL
# api.security.token.secret=SUA_CHAVE_SECRETA_PARA_JWT

# 4. Execute a aplicação (requer Maven e Java 17 instalados)
$ mvn spring-boot:run
```
A API estará disponível em http://localhost:8080.
A documentação do Swagger estará disponível em http://localhost:8080/swagger-ui.html.

## 👨‍💻 Autor
Desenvolvido por Luiz Dessunte.

<p align="left">
<a href="https://www.linkedin.com/in/luiz-dessunte/" target="_blank">
<img src="https://img.shields.io/badge/-LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"/>
</a>
<a href="https://github.com/luizdessunte" target="_blank">
<img src="https://img.shields.io/badge/-GitHub-181717?style=for-the-badge&logo=github&logoColor=white" alt="GitHub"/>
</a>
</p>