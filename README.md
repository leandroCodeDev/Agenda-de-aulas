
# API de uma Plataforma de Tutoria Online


## Introdução

Este projeto é desenvolvido como parte do curso [Floripa Mais Tec](https://floripamaistec.pmf.sc.gov.br), durante o módulo de Spring, ministrado por [Gabriel Augustin](https://github.com/AugustinGabriel). A aplicação visa facilitar o controle de agendamentos de aulas, proporcionando uma plataforma online que conecta alunos que necessitam de auxílio em disciplinas específicas com tutores qualificados.
O objetivo é oferecer recursos para agendamento de sessões de tutoria e compartilhamento de materiais de estudo, proporcionando uma experiência educacional personalizada e eficiente. Essa iniciativa visa promover um ambiente de ensino colaborativo e acessível, contribuindo para o desenvolvimento acadêmico dos alunos e facilitando o trabalho dos tutores.

## Tecnologias Utilizadas

- [Java](https://www.java.com/pt-BR/download/help/whatis_java.html)
- [Spring](https://spring.io/)
- [PostgreSQL](https://www.postgresql.org/)
- [Docker](https://www.docker.com/)

## Ferramentas Utilizadas

- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/)
- [Insomnia](https://insomnia.rest/)
- [Trello](https://trello.com/pt-BR)

## Pré-Requisitos

- JDK 21 ou superior instalado
- Git instalado na sua máquina
- IntelliJ IDEA
- Docker
- Docker Compose

## Dependências

1. **Spring Boot Starter for Spring Data JPA**:
    - GroupId: `org.springframework.boot`
    - ArtifactId: `spring-boot-starter-data-jpa`

2. **Spring Boot Starter for Spring Web**:
    - GroupId: `org.springframework.boot`
    - ArtifactId: `spring-boot-starter-web`

3. **Spring Boot DevTools for hot reloading**:
    - GroupId: `org.springframework.boot`
    - ArtifactId: `spring-boot-devtools`

4. **PostgreSQL Driver for Spring Data JPA**:
    - GroupId: `org.postgresql`
    - ArtifactId: `postgresql`

5. **Spring Boot Starter for testing**:
    - GroupId: `org.springframework.boot`
    - ArtifactId: `spring-boot-starter-test`

6. **Springdoc OpenAPI Starter for generating API documentation**:
    - GroupId: `org.springdoc`
    - ArtifactId: `springdoc-openapi-starter-webmvc-ui`
    - Version: `2.4.0`

## Como Começar

### Instalação

**Clonando o Repositório**

```bash
git clone https://github.com/leandroCodeDev/pseudo-biblioteca-spring.git
```

**Inicializando o Banco de Dados**

```bash
docker-compose up -d
```

**Execução**

Abra o projeto no IntelliJ IDEA e execute-o usando o atalho de execução da IDE.

## Documentação da API

### Servidor

- **URL**: [http://localhost:8090](http://localhost:8090)
- **Descrição**: URL do servidor gerado.


### Endpoints de Alunos

#### 1. Obter Aluno

- **GET /alunos/{id}**
    - **Descrição**: Obtém informações de um aluno pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do aluno a ser obtido.
    - **Respostas**:
        - **200 OK**: Retorna as informações do aluno.
            - Tipo de conteúdo: application/json
            - Schema:
              ```json
              {
                "type": "object",
                "properties": {
                  "id": {
                    "type": "string",
                    "format": "uuid",
                    "description": "O ID único do aluno."
                  },
                  "nome": {
                    "type": "string",
                    "description": "O nome do aluno."
                  }
                },
                "required": ["id", "nome"],
                "additionalProperties": false
              }
              ```
        - **404 Not Found**: Aluno não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Aluno não encontrado.
              ```

#### 2. Atualizar Aluno

- **PUT /alunos/{id}**
    - **Descrição**: Atualiza as informações de um aluno pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do aluno a ser atualizado.
    - **Corpo da Requisição**:
        - Tipo de conteúdo: application/json
        - Schema:
          ```json
          {
            "type": "object",
            "properties": {
              "nome": {
                "type": "string",
                "description": "O novo nome do aluno."
              }
            },
            "required": ["nome"],
            "additionalProperties": false
          }
          ```
    - **Respostas**:
        - **200 OK**: Aluno atualizado com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Aluno atualizado com sucesso.
              ```
        - **404 Not Found**: Aluno não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Aluno não encontrado.
              ```

#### 3. Excluir Aluno

- **DELETE /alunos/{id}**
    - **Descrição**: Exclui um aluno pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do aluno a ser excluído.
    - **Respostas**:
        - **200 OK**: Aluno excluído com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Aluno excluído com sucesso.
              ```
        - **404 Not Found**: Aluno não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Aluno não encontrado.
              ```

#### 4. Listar Alunos

- **GET /alunos**
    - **Descrição**: Obtém uma lista de todos os alunos.
    - **Respostas**:
        - **200 OK**: Retorna a lista de alunos.
            - Tipo de conteúdo: application/json
            - Exemplo de resposta:
              ```json
              [
                {
                  "id": "123e4567-e89b-12d3-a456-426614174001",
                  "nome": "Maria",
                  "agendas": []
                },
                {
                  "id": "123e4567-e89b-12d3-a456-426614174002",
                  "nome": "João",
                  "agendas": []
                }
              ]
              ```
        - **404 Not Found**: Nenhum aluno encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Nenhum aluno encontrado.
              ```

#### 2. Atualizar Aluno

- **PUT /alunos/{id}**
    - **Descrição**: Atualiza as informações de um aluno pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do aluno a ser atualizado.
    - **Corpo da Requisição**:
        - Tipo de conteúdo: application/json
        - Schema:
          ```json
          {
            "type": "object",
            "properties": {
              "nome": {
                "type": "string",
                "description": "O novo nome do aluno."
              },
              "agendas": {
                 "type": "array",
                    "items": {
                    "$ref": "#/components/schemas/AgendaDto"
                 },
                 "description": "As agendas associadas ao aluno."
              }
            },
            "required": ["nome"],
            "additionalProperties": false
          }
          ```
    - **Respostas**:
        - **200 OK**: Aluno atualizado com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Aluno atualizado com sucesso.
              ```
        - **404 Not Found**: Aluno não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Aluno não encontrado.
              ```

#### 3. Excluir Aluno

- **DELETE /alunos/{id}**
    - **Descrição**: Exclui um aluno pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do aluno a ser excluído.
    - **Respostas**:
        - **200 OK**: Aluno excluído com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Aluno excluído com sucesso.
              ```
        - **404 Not Found**: Aluno não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Aluno não encontrado.
              ```


### Endpoints de Tutores

#### 1. Obter Tutor

- **GET /tutores/{id}**
    - **Descrição**: Obtém informações de um tutor pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do tutor a ser obtido.
    - **Respostas**:
        - **200 OK**: Retorna as informações do tutor.
            - Tipo de conteúdo: application/json
            - Schema:
              ```json
              {
                "type": "object",
                "properties": {
                  "id": {
                    "type": "string",
                    "format": "uuid",
                    "description": "O ID único do tutor."
                  },
                  "nome": {
                    "type": "string",
                    "description": "O nome do tutor."
                  },
                  "especialidade": {
                    "type": "string",
                    "description": "A especialidade do tutor."
                  },
                  "agendas": {
                    "type": "array",
                    "items": {
                      "$ref": "#/components/schemas/AgendaDto"
                    },
                    "description": "As agendas associadas ao tutor."
                  }
                },
                "required": ["id", "nome", "especialidade", "agendas"],
                "additionalProperties": false
              }
              ```
        - **404 Not Found**: Tutor não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Tutor não encontrado.
              ```

#### 2. Atualizar Tutor

- **PUT /tutores/{id}**
    - **Descrição**: Atualiza as informações de um tutor pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do tutor a ser atualizado.
    - **Corpo da Requisição**:
        - Tipo de conteúdo: application/json
        - Schema:
          ```json
          {
            "type": "object",
            "properties": {
              "nome": {
                "type": "string",
                "description": "O novo nome do tutor."
              },
              "especialidade": {
                "type": "string",
                "description": "A nova especialidade do tutor."
              }
            },
            "required": ["nome", "especialidade"],
            "additionalProperties": false
          }
          ```
    - **Respostas**:
        - **200 OK**: Tutor atualizado com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Tutor atualizado com sucesso.
              ```
        - **404 Not Found**: Tutor não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Tutor não encontrado.
              ```

#### 3. Excluir Tutor

- **DELETE /tutores/{id}**
    - **Descrição**: Exclui um tutor pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do tutor a ser excluído.
    - **Respostas**:
        - **200 OK**: Tutor excluído com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Tutor excluído com sucesso.
              ```
        - **404 Not Found**: Tutor não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Tutor não encontrado.
              ```

#### 4. Listar Tutores

- **GET /tutores**
    - **Descrição**: Obtém uma lista de todos os tutores.
    - **Respostas**:
        - **200 OK**: Retorna a lista de tutores.
            - Tipo de conteúdo: application/json
            - Exemplo de resposta:
              ```json
              [
                {
                  "id": "123e4567-e89b-12d3-a456-426614174001",
                  "nome": "João",
                  "especialidade": "Matemática",
                  "agendas": []
                },
                {
                  "id": "123e4567-e89b-12d3-a456-426614174002",
                  "nome": "Maria",
                  "especialidade": "Física",
                  "agendas": []
                }
              ]
              ```
        - **404 Not Found**: Nenhum tutor encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Nenhum tutor encontrado.
              ```


### Endpoints de Agendas

#### 1. Obter Agenda

- **GET /agendas/{id}**
    - **Descrição**: Obtém informações de uma agenda pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único da agenda a ser obtida.
    - **Respostas**:
        - **200 OK**: Retorna as informações da agenda.
            - Tipo de conteúdo: application/json
            - Schema:
              ```json
              {
                "type": "object",
                "properties": {
                  "id": {
                    "type": "string",
                    "format": "uuid",
                    "description": "O ID único da agenda."
                  },
                  "nome": {
                    "type": "string",
                    "description": "O nome da agenda."
                  },
                  "status": {
                    "type": "string",
                    "description": "O status da agenda."
                  },
                  "tema": {
                    "type": "string",
                    "description": "O tema da agenda."
                  },
                  "descricao": {
                    "type": "string",
                    "description": "A descrição da agenda."
                  },
                  "dataAula": {
                    "type": "string",
                    "format": "date-time",
                    "description": "A data da aula agendada."
                  },
                  "tutor": {
                    "$ref": "#/components/schemas/TutorDto",
                    "description": "O tutor associado à agenda."
                  },
                  "aluno": {
                    "$ref": "#/components/schemas/AlunoDto",
                    "description": "O aluno associado à agenda."
                  }
                },
                "required": ["id", "nome", "status", "tema", "descricao", "dataAula", "tutor", "aluno"],
                "additionalProperties": false
              }
              ```
        - **404 Not Found**: Agenda não encontrada.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Agenda não encontrada.
              ```

#### 2. Atualizar Agenda

- **PUT /agendas/{id}**
    - **Descrição**: Atualiza as informações de uma agenda pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único da agenda a ser atualizada.
    - **Corpo da Requisição**:
        - Tipo de conteúdo: application/json
        - Schema:
          ```json
          {
            "type": "object",
            "properties": {
              "nome": {
                "type": "string",
                "description": "O novo nome da agenda."
              },
              "status": {
                "type": "string",
                "description": "O novo status da agenda."
              },
              "tema": {
                "type": "string",
                "description": "O novo tema da agenda."
              },
              "descricao": {
                "type": "string",
                "description": "A nova descrição da agenda."
              },
              "dataAula": {
                "type": "string",
                "format": "date-time",
                "description": "A nova data da aula agendada."
              },
              "tutor": {
                "$ref": "#/components/schemas/TutorDto",
                "description": "O nova tutor associado à agenda."
              },
              "aluno": {
                "$ref": "#/components/schemas/AlunoDto",
                "description": "O nova aluno associado à agenda."
              }
            },
            "required": ["nome", "status", "tema", "descricao", "dataAula","tutor","aluno"],
            "additionalProperties": false
          }
          ```
    - **Respostas**:
        - **200 OK**: Agenda atualizada com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Agenda atualizada com sucesso.
              ```
        - **404 Not Found**: Agenda não encontrada.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Agenda não encontrada.
              ```

#### 3. Excluir Agenda

- **DELETE /agendas/{id}**
    - **Descrição**: Exclui uma agenda pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único da agenda a ser excluída.
    - **Respostas**:
        - **200 OK**: Agenda excluída com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Agenda excluída com sucesso.
              ```
        - **404 Not Found**: Agenda não encontrada.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Agenda não encontrada.
              ```

#### 4. Listar Agendas

- **GET /agendas**
    - **Descrição**: Obtém uma lista de todas as agendas.
    - **Respostas**:
        - **200 OK**: Retorna a lista de agendas.
            - Tipo de conteúdo: application/json
            - Exemplo de resposta:
              ```json
              [
                {
                  "id": "123e4567-e89b-12d3-a456-426614174001",
                  "nome": "Aula de Matemática",
                  "status": "Agendada",
                  "tema": "Álgebra",
                  "descricao": "Revisão de conceitos básicos de álgebra.",
                  "dataAula": "2024-03-22T10:00:00Z",
                  "tutor": {
                    "id": "123e4567-e89b-12d3-a456-426614174002",
                    "nome": "João",
                    "especialidade": "Matemática",
                    "agendas": []
                  },
                  "aluno": {
                    "id": "123e4567-e89b-12d3-a456-426614174003",
                    "nome": "Maria",
                    "agendas": []
                  }
                },
                {
                  "id": "123e4567-e89b-12d3-a456-426614174004",
                  "nome": "Aula de Física",
                  "status": "Concluída",
                  "tema": "Óptica",
                  "descricao": "Discussão sobre fenômenos ópticos.",
                  "dataAula": "2024-03-25T14:00:00Z",
                  "tutor": {
                    "id": "123e4567-e89b-12d3-a456-426614174002",
                    "nome": "João",
                    "especialidade": "Física",
                    "agendas": []
                  },
                  "aluno": {
                    "id": "123e4567-e89b-12d3-a456-426614174003",
                    "nome": "Maria",
                    "agendas": []
                  }
                }
              ]
              ```
        - **404 Not Found**: Nenhuma agenda encontrada.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Nenhuma agenda encontrada.
              ```

### Endpoints de Materiais

#### 1. Obter Material

- **GET /materiais/{id}**
    - **Descrição**: Obtém informações de um material pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do material a ser obtido.
    - **Respostas**:
        - **200 OK**: Retorna as informações do material.
            - Tipo de conteúdo: application/json
            - Schema:
              ```json
              {
                "type": "object",
                "properties": {
                  "id": {
                    "type": "string",
                    "format": "uuid",
                    "description": "O ID único do material."
                  },
                  "caminhoArquivo": {
                    "type": "string",
                    "description": "O caminho do arquivo do material."
                  },
                  "urlArquivo": {
                    "type": "string",
                    "description": "A URL do arquivo do material."
                  },
                  "agenda": {
                    "$ref": "#/components/schemas/AgendaDto",
                    "description": "A agenda associada ao material."
                  }
                },
                "required": ["id", "caminhoArquivo", "urlArquivo", "agenda"],
                "additionalProperties": false
              }
              ```
        - **404 Not Found**: Material não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Material não encontrado.
              ```

#### 2. Atualizar Material

- **PUT /materiais/{id}**
    - **Descrição**: Atualiza as informações de um material pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do material a ser atualizado.
    - **Corpo da Requisição**:
        - Tipo de conteúdo: application/json
        - Schema:
          ```json
          {
            "type": "object",
            "properties": {
              "caminhoArquivo": {
                "type": "string",
                "description": "O novo caminho do arquivo do material."
              },
              "urlArquivo": {
                "type": "string",
                "description": "A nova URL do arquivo do material."
              }
            },
            "required": ["caminhoArquivo", "urlArquivo"],
            "additionalProperties": false
          }
          ```
    - **Respostas**:
        - **200 OK**: Material atualizado com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Material atualizado com sucesso.
              ```
        - **404 Not Found**: Material não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Material não encontrado.
              ```

#### 3. Excluir Material

- **DELETE /materiais/{id}**
    - **Descrição**: Exclui um material pelo ID.
    - **Parâmetros**:
        - `id` (path, string, uuid, obrigatório): ID único do material a ser excluído.
    - **Respostas**:
        - **200 OK**: Material excluído com sucesso.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Material excluído com sucesso.
              ```
        - **404 Not Found**: Material não encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Material não encontrado.
              ```

#### 4. Listar Materiais

- **GET /materiais**
    - **Descrição**: Obtém uma lista de todos os materiais.
    - **Respostas**:
        - **200 OK**: Retorna a lista de materiais.
            - Tipo de conteúdo: application/json
            - Exemplo de resposta:
              ```json
              [
                {
                  "id": "123e4567-e89b-12d3-a456-426614174001",
                  "caminhoArquivo": "/caminho/do/arquivo1.pdf",
                  "urlArquivo": "http://exemplo.com/arquivo1.pdf",
                  "agenda": {
                    "id": "123e4567-e89b-12d3-a456-426614174002",
                    "nome": "Aula de Matemática",
                    "status": "Agendada",
                    "tema": "Álgebra Linear",
                    "descricao": "Revisão de conceitos de álgebra linear.",
                    "dataAula": "2024-03-25T10:00:00Z",
                    "tutor": {
                      "id": "123e4567-e89b-12d3-a456-426614174003",
                      "nome": "João",
                      "especialidade": "Matemática",
                      "agendas": []
                    },
                    "aluno": {
                      "id": "123e4567-e89b-12d3-a456-426614174004",
                      "nome": "Maria",
                      "agendas": []
              
                    }
                  }
                },
                {
                  "id": "123e4567-e89b-12d3-a456-426614174005",
                  "caminhoArquivo": "/caminho/do/arquivo2.pdf",
                  "urlArquivo": "http://exemplo.com/arquivo2.pdf",
                  "agenda": {
                    "id": "123e4567-e89b-12d3-a456-426614174006",
                    "nome": "Aula de Física",
                    "status": "Concluída",
                    "tema": "Leis de Newton",
                    "descricao": "Aplicação das leis de Newton em problemas práticos.",
                    "dataAula": "2024-03-27T14:00:00Z",
                    "tutor": {
                      "id": "123e4567-e89b-12d3-a456-426614174007",
                      "nome": "Ana",
                      "especialidade": "Física",
                      "agendas": []
                    },
                    "aluno": {
                      "id": "123e4567-e89b-12d3-a456-426614174008",
                      "nome": "Carlos",
                      "agendas": []
                    }
                  }
                }
              ]
              ```
        - **404 Not Found**: Nenhum material encontrado.
            - Tipo de conteúdo: text/plain
            - Exemplo de resposta:
              ```
              Nenhum material encontrado.
              ```

