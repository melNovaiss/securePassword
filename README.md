# Secure Password Validation Service
Este projeto é uma API REST desenvolvida com Spring Boot que valida uma senha de acordo com critérios de segurança. O serviço verifica se a senha cumpre os seguintes requisitos:
- Pelo menos 8 caracteres
- Pelo menos uma letra maiúscula
- Pelo menos uma letra minúscula
- Pelo menos um dígito numérico
- Pelo menos um caractere especial (e.g., !@#$%)

Desafio desenvolvido pela comunidade [Back-End Brasil](https://github.com/backend-br).  
Saiba mais: [Senha Segura](https://github.com/backend-br/desafios/blob/master/secure-password/PROBLEM.md).

## Requisitos
Antes de rodar o projeto, certifique-se de ter as seguintes ferramentas instaladas:
- Java 17+ (Recomendado JDK 21)
- Maven para gerenciamento de dependências

## Instalação e Execução
Clone o repositório:
```bash
git clone https://github.com/melnovais/secure-password.git
```
Navegue até o diretório do projeto:
```bash
cd secure-password
```
Compile e execute o projeto usando Maven:
```bash
mvn spring-boot:run
```
A API estará rodando no endereço padrão:
```bash
http://localhost:8080
```

## Endpoint
Validar Senha
- URL: /validate-password
- Método: POST
- Descrição: Valida a senha recebida de acordo com os critérios de segurança.
Exemplo de Requisição:
```json
POST http://localhost:8080/validate-password
Content-Type: application/json

{
    "password": "vYQIYxO&p$yfI^r"
}

```
Respostas possíveis:
- Senha válida (204 No Content):
```http
HTTP/1.1 204 No Content
```
- Senha inválida (400 Bad Request):
```http
HTTP/1.1 400 Bad Request
Content-Type: application/json

{
    "errors": [
        "A senha deve conter pelo menos um dígito numérico."
    ]
}
```
