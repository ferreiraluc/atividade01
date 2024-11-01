
# Atividade Mapeamento e Desenvolvimento de APIs

## Introdução

Esta aplicação tem como objetivo gerenciar agendamentos de consultas médicas, permitindo a criação, leitura, atualização e exclusão de consultas e pacientes. A aplicação também implementa autenticação por meio de tokens JWT (JSON Web Tokens), permitindo que apenas usuários autenticados acessem os endpoints protegidos. Além disso, conta com um sistema de auditoria que registra automaticamente as operações realizadas no sistema, como criação, atualização e exclusão de dados, armazenando essas informações em uma tabela de logs no banco de dados para fins de rastreamento e segurança.


## Endpoints
### 1. Login

**POST** `/api/login`

#### Request Body (JSON):
```json
{
    "username": "admin",
    "password": "123"
}

```

### 2. Cadastrar Endereço

**POST** `/api/endereco/cadastrar`

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

### 3. Cadastrar Paciente

**POST** `/api/pacientes/cadastrar`

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

### 4. Agendar Consulta

**POST** `/api/consultas/agendar`

#### Request Body (JSON):
```json
{
    "dataHora": "2024-01-01T10:00:00",
    "paciente": {
        "id": 1
    }
}
```

### 5. Listar Consultas por Período

**GET** `/api/consultas/periodo?dataInicio=2024-01-01T00:00:00&dataFim=2024-10-31T23:59:59`

#### Parâmetros:
- `dataInicio`: Data e hora de início do período (formato ISO).
- `dataFim`: Data e hora de término do período (formato ISO).

#### Exemplo:
```
/api/consultas/periodo?dataInicio=2023-12-01T00:00:00&dataFim=2024-12-12T23:59:59
```
