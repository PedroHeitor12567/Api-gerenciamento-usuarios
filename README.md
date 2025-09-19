# ![API Badge](https://img.shields.io/badge/API-Spring%20Boot-blue) API de Usuários em Java com Spring Boot

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![Build](https://img.shields.io/badge/Build-Maven-lightgrey)](https://maven.apache.org/)

Uma API simples para gerenciamento de usuários, criada como projeto de estudo. Permite **criação**, **listagem**, **busca por ID** e **deleção** de usuários, com respostas amigáveis e status HTTP corretos.  

---

## 📦 Estrutura do projeto

```
src/main/java/com/pedroferreira/apisimples
 ├── ApiSimplesApplication.java        # Classe principal do Spring Boot
 ├── controller
 │    └── UserController.java  # Endpoints da API
 ├── model
 │    ├── User.java            # Entidade User
 ├── repository
 │    └── UserRepository.java  # Interface de acesso ao banco
 └── service
      └── UserService.java     # Lógica de negócio
```

---

## ⚡ Endpoints disponíveis

### 1️⃣ Listar todos os usuários
- **GET** `/users`  
- **Exemplo de resposta:**
```json
[
  {
    "id": 1,
    "nome": "Pedro",
    "email": "pedro@email.com"
  }
]
```

---

### 2️⃣ Buscar usuário por ID
- **GET** `/users/{id}`  
- **Resposta sucesso:**
```json
{
  "id": 1,
  "nome": "Pedro",
  "email": "pedro@email.com"
}
```
- **Resposta não encontrado:**
```json
{
  "mensagem": "Usuário com id 99 não encontrado."
}
```

---

### 3️⃣ Criar usuário
- **POST** `/users`  
- **Body (JSON):**
```json
{
  "nome": "Pedro",
  "email": "pedro@email.com"
}
```
- **Resposta sucesso:**
```json
{
  "mensagem": "Usuário 'Pedro' salvo com sucesso!"
}
```
- **Status HTTP:** 201 Created

---

### 4️⃣ Deletar usuário
- **DELETE** `/users/{id}`  
- **Resposta sucesso:**
```json
{
  "mensagem": "Usuário com id 1 deletado com sucesso!"
}
```
- **Resposta não encontrado:**
```json
{
  "mensagem": "Usuário com id 99 não encontrado."
}
```
- **Status HTTP:** 200 OK ou 404 Not Found

---

## 🗄 Banco de dados

- **H2 Database** em memória  
- Configuração (`application.properties`):
```properties
spring.datasource.url=jdbc:h2:mem:meubanco
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```
- Console H2: `http://localhost:8080/h2-console`  

---

## 🚀 Como rodar o projeto

1. Clone o repositório:
```bash
git clone <url-do-projeto>
```

2. Acesse a pasta do projeto:
```bash
cd nome-do-projeto
```

3. Rode o projeto usando Maven:
```bash
mvn spring-boot:run
```

4. Teste os endpoints usando **Postman**, **cURL** ou navegador:
```
http://localhost:8080/users
```

---

## 💡 Diferenciais desta API

- Respostas consistentes e amigáveis (`mensagem` no corpo)  
- Tratamento de erros (usuário não encontrado → 404)  
- Banco em memória H2 para testes rápidos  
- Estrutura modular (Controller, Service, Repository, Model)

---

## 👨‍💻 Desenvolvedor

**Pedro Heitor**
