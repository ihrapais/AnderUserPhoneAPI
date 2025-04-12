

### 📌 **README.md**

# 📚 UserPhoneLearning - Exemplo Didático com Spring Boot

Este é um projeto didático para ensino de **CRUD com Spring Boot, JPA e MySQL**, demonstrando um relacionamento **1:N** entre `User` e `Phone`.

## 🚀 Tecnologias Utilizadas
- **Java 17**  
- **Spring Boot 3**  
- **Spring Data JPA**  
- **MySQL**  
- **Lombok**  
- **Maven**



## ⚙️ Configuração do Ambiente

### 1️⃣ **Clonar o Repositório**
```bash
git clone https://github.com/seu-usuario/UserPhoneLearning.git
cd UserPhoneLearning
```

### 2️⃣ **Configurar o Banco de Dados**
Crie um banco de dados MySQL chamado **db_example**:
```sql
CREATE DATABASE db_example;
```

### 3️⃣ **Configurar o `application.properties`**
No arquivo `src/main/resources/application.properties`, configure o acesso ao banco:
```properties
spring.application.name=UserPhoneAPI
#Update the database schema based on the entities create-drop / update
spring.jpa.hibernate.ddl-auto= update
#create database if not exists mysql true spring boot
spring.datasource.url=jdbc:mysql://localhost:3306/UserPhoneAPI?createDatabaseIfNotExist=true
#DB User
spring.datasource.username=USERNAME
#DB password
spring.datasource.password=PASSWORD
```

### 4️⃣ **Executar o Projeto**
No terminal, dentro da pasta do projeto, execute:
```bash
./mvnw spring-boot:run
```
ou  
```bash
mvn spring-boot:run
```

---

## 📌 Estrutura das Entidades

### **User (Usuário)**
```json
{
  "id": 1,
  "name": "Herysson",
  "email": "herysson@example.com",
  "phones": [
    { "id": 1, "number": "99999-9999" },
    { "id": 2, "number": "88888-8888" }
  ]
}
```

### **Phone (Telefone)**
```json
{
  "id": 1,
  "number": "99999-9999",
  "user": { "id": 1, "name": "Herysson", "email": "herysson@example.com" }
}
```

---

## 📢 Endpoints da API

### 🔹 **1. Criar um Usuário com Telefones**
📌 **POST** `/users`  
📥 **Exemplo de Corpo (JSON)**
```json
{
  "name": "Herysson",
  "email": "herysson@example.com",
  "phones": [
    { "number": "99999-9999" },
    { "number": "88888-8888" }
  ]
}
```
📤 **Resposta**
```json
{
  "id": 1,
  "name": "Herysson",
  "email": "herysson@example.com",
  "phones": [
    { "id": 1, "number": "99999-9999" },
    { "id": 2, "number": "88888-8888" }
  ]
}
```

---

### 🔹 **2. Listar Todos os Usuários**
📌 **GET** `/users`  
📤 **Resposta**
```json
[
  {
    "id": 1,
    "name": "Herysson",
    "email": "herysson@example.com",
    "phones": [
      { "id": 1, "number": "99999-9999" },
      { "id": 2, "number": "88888-8888" }
    ]
  }
]
```

---

### 🔹 **3. Buscar Usuário por ID**
📌 **GET** `/users/{id}`  
📤 **Resposta**
```json
{
  "id": 1,
  "name": "Herysson",
  "email": "herysson@example.com",
  "phones": [
    { "id": 1, "number": "99999-9999" },
    { "id": 2, "number": "88888-8888" }
  ]
}
```

---

### 🔹 **4. Deletar Usuário por ID**
📌 **DELETE** `/users/{id}`  
📤 **Resposta**
```json
{
  "message": "Usuário deletado com sucesso."
}
```

---


### 🔹 **5. Atualizar Usuário 

📌 **PUT** `/users/{id}`

📥 **Exemplo de Corpo (JSON)**

```json
{
  "name": "Herysson Novo",
  "email": "heryssonnovo@example.com",
  "phones": [
    { "id": 1, "number": "00000-9999" },
    { "id": 2, "number": "00000-8888" }
  ]
}
```
📤 **Resposta**

```json
{
  "id": 1,
  "name": "Herysson Novo",
  "email": "heryssonnovo@example.com",
  "phones": [
    { "id": 1, "number": "00000-9999" },
    { "id": 2, "number": "00000-8888" }
  ]
}
```

📤 **Resposta de Erro (usuário não encontrado)**

```http
404 Not Found
```

---

## 📝 Considerações Finais
Este projeto é um exemplo didático para ensino de **Spring Boot, JPA e MySQL**, abordando:
- CRUD básico
- Relacionamento **1:N** entre entidades
- Utilização de Lombok para reduzir código boilerplate
- Configuração simples para ensino e aprendizado

Caso tenha dúvidas ou sugestões, fique à vontade para contribuir! 🚀

---

## 📜 Licença

Este projeto é licenciado sob a Licença MIT. [LICENSE](LICENSE) 
