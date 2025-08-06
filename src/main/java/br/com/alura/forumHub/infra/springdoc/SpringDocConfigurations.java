package br.com.alura.forumHub.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Configura o esquema de segurança para autenticação JWT
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                // Aplica o esquema de segurança a todos os endpoints
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"))
                // Define as informações gerais da API, como título, descrição e contato
                .info(new Info()
                        .title("ForumHub API")
                        .description("API Rest da aplicação ForumHub, contendo as funcionalidades de CRUD de tópicos e autenticação de utilizadores.")
                        .contact(new Contact()
                                .name("Luiz Dessunte")
                                .email("seu-email@exemplo.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}