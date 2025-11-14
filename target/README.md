# 🛍️ Power Over - Controle de Estoque de Loja de Roupas

> Sistema simples e objetivo de **controle de estoque** desenvolvido em **Java com Spring Boot** e **MySQL**, seguindo boas práticas de **MVC**.  
> Criado como projeto real para gestão de produtos, com funcionalidades de **CRUD completo**.

---

## 🚀 Funcionalidades

- **Cadastrar produtos** com nome, preço e quantidade em estoque.
- **Listar todos os produtos** cadastrados.
- **Buscar produto por ID**.
- **Atualizar produto** (nome, preço ou quantidade).
- **Excluir produto** do estoque.
- **Controle de entradas e saídas** de estoque.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.x**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**
- **Postman** (testes de API)

---

## 📦 Estrutura do Projeto (MVC)

src/main/java/com/powerover
├── controller # Endpoints REST
├── model # Entidades JPA
├── repository # Camada de persistência
└── service # Regras de negócio

## ⚙️ Configuração do Banco de Dados

Crie o banco no MySQL:
   ```sql
   CREATE DATABASE power_over_db;

Ajuste o arquivo src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/power_over_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

📬 Endpoints Principais
Criar Produto (POST)
/products
{
  "name": "Camiseta Branca",
  "price": 49.90,
  "quantity": 100
}

Listar Produtos (GET)
/products

Buscar Produto por ID (GET)
/products/{id}

Atualizar Produto (PUT)
/products/{id}
{
  "name": "Camiseta Premium",
  "price": 59.90,
  "quantity": 80
}

Deletar Produto (DELETE)
/products/{id}

👨‍💻 Autor

Hildebrando Vanique Miranda

    LinkedIn: https://www.linkedin.com/in/hildebrandomiranda/

    GitHub: https://github.com/mirandahildebrando