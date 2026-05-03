# Validacao API

API REST em Spring Boot que verifica se uma chave alfanumérica existe em uma lista predefinida.

## Requisitos

- Java 17+
- Maven (ou use o wrapper `./mvnw` incluído no projeto)

## Executar o projeto

```bash
./mvnw spring-boot:run
```

A aplicação sobe na porta **8080**.

---

## Endpoint

```
POST http://localhost:8080/api/verificar
Content-Type: application/json
```

### Corpo da requisição

```json
{
  "chave": "A1B2C",
  "valor": 5
}
```

| Campo   | Tipo    | Regras                                                              |
|---------|---------|---------------------------------------------------------------------|
| `chave` | String  | Obrigatório · exatamente 5 caracteres · letras e números obrigatórios |
| `valor` | Integer | Obrigatório · entre 1 e 10                                          |

---

## Respostas

### Chave encontrada — HTTP 200
```
SIM, EXISTE !
```

### Chave não encontrada — HTTP 200
```
NÃO EXISTE !
```

### Dados inválidos — HTTP 400
```json
{
  "timestamp": "2026-05-03T19:56:46.511Z",
  "status": 400,
  "error": "Bad Request",
  "path": "/api/verificar"
}
```

---

## Chaves cadastradas

| Chave |
|-------|
| T4KW9 |
| B7FQ2 |
| H3ND6 |
| V5RJ1 |

---

## Como testar

### Via curl (terminal)

**Chave que existe:**
```bash
curl -X POST http://localhost:8080/api/verificar \
  -H "Content-Type: application/json" \
  -d '{"chave": "T4KW9", "valor": 5}'
```
Resposta: `SIM, EXISTE !`

**Chave que não existe:**
```bash
curl -X POST http://localhost:8080/api/verificar \
  -H "Content-Type: application/json" \
  -d '{"chave": "Z5Y4X", "valor": 3}'
```
Resposta: `NÃO EXISTE !`

**Chave com menos de 5 caracteres:**
```bash
curl -X POST http://localhost:8080/api/verificar \
  -H "Content-Type: application/json" \
  -d '{"chave": "A1B", "valor": 3}'
```
Resposta: `HTTP 400 Bad Request`

**Chave só com letras (sem número):**
```bash
curl -X POST http://localhost:8080/api/verificar \
  -H "Content-Type: application/json" \
  -d '{"chave": "ABCDE", "valor": 3}'
```
Resposta: `HTTP 400 Bad Request`

**Valor fora do intervalo:**
```bash
curl -X POST http://localhost:8080/api/verificar \
  -H "Content-Type: application/json" \
  -d '{"chave": "A1B2C", "valor": 11}'
```
Resposta: `HTTP 400 Bad Request`

**Body vazio:**
```bash
curl -X POST http://localhost:8080/api/verificar \
  -H "Content-Type: application/json" \
  -d '{}'
```
Resposta: `HTTP 400 Bad Request`

### Via Postman / Insomnia

1. Método: `POST`
2. URL: `http://localhost:8080/api/verificar`
3. Header: `Content-Type: application/json`
4. Body (raw JSON):
```json
{
  "chave": "B7FQ2",
  "valor": 7
}
```

---

## Estrutura do projeto

```
src/main/java/com/example/demo/
├── DemoApplication.java        # Classe principal
├── controller/
│   └── ValidacaoController.java  # Recebe as requisições HTTP e verifica a chave
└── dto/
    └── ValidacaoRequest.java     # Validação dos dados de entrada
```
