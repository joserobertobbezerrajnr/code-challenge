
# DummyJSON Client

## Descrição do Projeto

Este projeto é um microsserviço Java que interage com a API pública [DummyJSON](https://dummyjson.com/docs/products) para realizar operações de busca de produtos. O projeto foi desenvolvido usando Java 8 e Spring Boot 2.6.x. e migragado para Java 17 e Spring Boot 3.5.x

## Funcionalidades

- **Consulta de Produtos:** Realiza chamadas para a API do DummyJSON para buscar informações sobre produtos.
- **Integração com Feign Client:** Utiliza Spring Cloud OpenFeign para realizar chamadas HTTP de maneira declarativa, substituindo o uso de RestTemplate.
- **Validação de Dados:** Implementada com Jakarta Validation (jakarta.validation), garantindo a consistência dos dados de entrada.
- **Gestão de Dependências:** Configurado para utilizar @Autowired e injeção de dependências via Spring.
- **Testes de Integração:** Utiliza JUnit 5 e @SpringBootTest para garantir o correto funcionamento dos componentes.

## Estrutura do Projeto

```bash
dummyjson-client
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.dummyjsonclient
│   │   │       ├── config
│   │   │       │   └── ProductClientConfig.java
│   │   │       ├── controller
│   │   │       │   └── ProductController.java
│   │   │       │   └── HealthController.java
│   │   │       ├── dto
│   │   │       │   └── Product.java
│   │   │       │   └── ProductListResponse.java
│   │   │       ├── service
│   │   │       │   └── ProductService.java
│   │   └── resources
│   │       └── application.yaml
│   └── test
│       ├── java
│       │   └── com.example.dummyjsonclient
│       │       ├── config
│       │       │   └── ProductClientConfigTest.java
│       │       └── controller
│       │       │   └── ProductControllerTest.java
│       │       ├── dto
│       │       │   └── ProductTest.java
│       │       └── service
│       │           └── ProductServiceTest.java
│       └── resources
└── pom.xml
```

## Passos para Executar o Projeto

### Pré-requisitos

- **Java 17
- **Maven 3.8.x**

### Executar a Aplicação

1. Clone o repositório:

    ```bash
    git clone https://github.com/joserobertobbezerrajnr/code-challenge
    ```

2. Compile e execute o projeto:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. Acesse o serviço:

    O serviço estará disponível em: `http://localhost:8080/api/health`
    O serviço de consulta estrá disponivel em: `http://localhost:8080/api/products` .

### Executar Testes

Para executar os testes unitários:

```bash
mvn clean test
```
