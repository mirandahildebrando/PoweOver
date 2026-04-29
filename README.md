⚡ PowerOver API | Sistema de Gestão de Vendas

O PowerOver é uma API REST desenvolvida para gerenciamento de vendas e controle de estoque, permitindo o cadastro de produtos, registro de transações e acompanhamento das operações comerciais.

A aplicação foi construída com foco em boas práticas de desenvolvimento backend, utilizando arquitetura em camadas, persistência com banco relacional e deploy em ambiente de produção.

🚀 API em Produção

👉 https://poweover.onrender.com

📄 Documentação (Swagger)

A API possui documentação interativa para testes dos endpoints:

👉 https://poweover.onrender.com/swagger-ui/index.html

🛠️ Tecnologias Utilizadas
Java 17
Spring Boot
Spring Data JPA
Hibernate
PostgreSQL (produção)
Maven
Swagger (OpenAPI)
🧱 Arquitetura

O projeto segue o padrão de arquitetura em camadas:

Controller → entrada e saída da API
Service → regras de negócio
Repository → acesso ao banco de dados
DTO → transferência de dados entre camadas
📌 Funcionalidades
Cadastro de produtos
Listagem de produtos
Atualização e remoção de produtos
Registro de vendas
Consulta de vendas
🗄️ Banco de Dados

A aplicação utiliza PostgreSQL em produção, hospedado externamente.

Os dados são persistidos e mantidos mesmo após reinicialização da aplicação.

⚙️ Execução Local
Pré-requisitos
Java 17+
Maven
Configuração

Configure o application.properties com suas credenciais de banco (PostgreSQL local ou remoto).

Rodar o projeto
mvn clean install
mvn spring-boot:run
🔗 Endpoints Principais
Produtos
POST /products → criar produto
GET /products → listar produtos
GET /products/{id} → buscar por id
PUT /products/{id} → atualizar
DELETE /products/{id} → deletar
Vendas
POST /sales → criar venda
GET /sales → listar vendas
GET /sales/{id} → buscar por id
📈 Observações
A API está em produção e pode ser testada via Swagger
O projeto utiliza banco relacional com persistência real
Estrutura preparada para evolução (ex: autenticação, integração com frontend)
