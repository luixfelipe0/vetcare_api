# Vetcare_API

##  Sobre o projeto

A Vetcare é uma clínica veterinária que atende múltiplos tipos de pets, e com veterinários de várias especialidades diferentes. Desenvolvido com Java e Spring Boot.

##  Tecnologias usadas

- Java 17
- Spring Boot 3
- MySQL
- Migrations com Flyway
- Spring Data JPA
- Documentação com OpenAPI Swagger 
- Build com Maven
- DevTools
- Lombok
- Bean Validation
- JUnit
- Mockito
- Jackson Tester

Desenvolvido na IntelliJ IDEA.
Durante a fase inicial do projeto também foi utilizado um bando de dados em memória, o H2 Database.

##  Funcionalidades

Operações CRUD para cadastro, listagem, detalhamento, atualização e listagem de veterinários, tutores e pets.

As tabelas de pet e tutor possuem um relacionamento bidirecional no banco de dados (MySQL), manyToOne e OneToMany respectivamente, ou seja, vários pets podem estar associados a um tutor, e um tutor pode ter uma lista com vários pets. 

A camada de infra possui interfaces repository para a persistência com o banco de dados, com queries personalizadas, e também uma classe específica para tratamento de exceptions, tanto do próprio Java quanto personalizadas.

Este projeto ainda não está em sua versão final, futuramente também será adicionada a funcionalidade de marcação de consultas dos pets com os veterinários, com toda a lógica e regras de negócio necessárias para tal. Também será implementado um sistema de autenticação e autorização com Spring Security e tokens auth0 JWT.

A aplicação foi devidamente testada usando JUnit e documentada com o Swagger.

## Conclusão

A Vetcare foi idealizado e feito para o Bootcamp da DIO de Java back-end, como o projeto final para a conclusão do mesmo.
Um agradecimento especial aos instrutores Venilton Júnior, Pamela Borges, Camila Cavalvante, Gleyson Sampaio e Elidiana Andrade, que foram os que me guiaram até aqui.
