
<h1 align="center">
  My Favorite Manga List
</h1>




## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [MySql](https://www.mysql.com/)
- [Docker](https://www.docker.com/)

## Práticas adotadas

- SOLID, YAGNI
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3
- Criação de Container e Imagem com Docker para garantir um ambiente consistente e escalável em diferentes plataformas.

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/my-manga-list-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Manga
```
$ http POST :8080/manga
name="Vagabond" author="Takehiko Inoue" genres=[{ "name": "Action" }, { "name": "Seinen" }]
[
  {
      "name": "Vagabond ",
      "author": "Takehiko Inoue",
      "genres": [
          { "name": "Shounem" },
          { "name": "Seinen" }
      ]
  }
]
```

- Listar Manga Pelo Ranking e Nome
```
$ http GET :8080/manga 

[
    {
        "id": 1,
        "name": "Vagabond ",
        "author": "Takehiko Inoue",
        "genreManga": [
            {
                "name": "Action"
            },
            {
                "name": "Seinen"
            }
        ],
        "averageNota": 0,
        "peopleVote": 0
    }
]
```

- Atualizar Manga
```
$ http PUT :8080/manga/1 
name="Vagabond" author="Takehiko Inoue" genres=[{ "name": "Shounem" }, { "name": "Seinen" }, {"name":"Action"}]

[]
```

- Remover Manga
```
http DELETE :8080/manga/1

[ ]
```

- Dar uma Nota para o manga
```
$ http POST :8080/rating/1
{ "rating":3}

[vote successful]
```
$ http GET :8080/manga 

[
    {
        "id": 1,
        "name": "Vagabond ",
        "author": "Takehiko Inoue",
        "genreManga": [
            {
                "name": "Action"
            },
            {
                "name": "Seinen"
            }
        ],
        "averageNota": 3,
        "peopleVote": 1
    }
]
```



## Detalhes do Projeto

- **GroupId**: com.marcos
- **ArtifactId**: my-manga-list
- **Versão**: 0.0.1-SNAPSHOT

## Requisitos

- Java JDK 21 ou superior
- Maven 3.3.0 ou superior
