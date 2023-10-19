package vet.care.plus.infra.springDoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vetcare_API")
                        .description("API Restful de uma clínica veterinária, com funcionalidades CRUD, cadastro " +
                                "listagem, detalhamento e inativação de Veterinários, Pets e Tutores. " +
                                "Futuramente faremos a adição da funcionalidade de marcação de consultas, autenticação e autorização.")
                        .contact(new Contact()
                                .name("Luiz Felipe Santos Silva")
                                .email("luiz_santos1811@outlook.com"))
                        .license(new License()
                                .name("Apache 4.0.0")
                                .url("http://vetcare/api/licenca")));
    }

}
