
# Atividade Mapeamento e Desenvolvimento de APIs

## Introdução

Este projeto tem como objetivo gerenciar agendamentos de consultas médicas, permitindo a criação, leitura, atualização e exclusão de consultas e pacientes.

## Tecnologias Utilizadas

* **Spring Boot:** Framework Java para desenvolvimento de aplicações web.
* **Spring Data JPA:** Framework para acesso a dados.
* **MySQL:** Banco de dados.

## Endpoints

### 1. Cadastrar Endereço

**POST** `/endereco`

#### Request Body (JSON):
```json
{
    "estado": "Parana",
    "cidade": "Curitiba",
    "rua": "Rua brasil",
    "numero": 10,
    "cep": "81844-220"
}
```

### 2. Cadastrar Paciente

**POST** `/pacientes`

#### Request Body (JSON):
```json
{
  "nome": "Lucas ferreira",
  "cpf": "12345678900",
  "email": "lucas@email.com",
  "telefone": "11987654321",
  "endereco": {
        "id": 1
  }
}
```

### 3. Cadastrar Consulta

**POST** `/consultas`

#### Request Body (JSON):
```json
{
    "dataHora": "2024-01-01T10:00:00",
    "paciente": {
        "id": 1
    }
}
```

### 4. Listar Consultas por Período

**GET** `/consultas/periodo`

#### Parâmetros:
- `dataInicio`: Data e hora de início do período (formato ISO).
- `dataFim`: Data e hora de término do período (formato ISO).

#### Exemplo:
```
/consultas/periodo?dataInicio=2023-12-01T00:00:00&dataFim=2024-12-12T23:59:59
```
