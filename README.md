⚡ PowerOver | Sistema de Gestão de Vendas (Enterprise Edition)
O PowerOver é uma solução robusta voltada para a automação de vendas e controle inteligente de inventário. Desenvolvida originalmente para atender demandas reais de mercado, a API foi aprimorada com o que há de mais moderno no ecossistema Spring Boot, garantindo alta performance, segurança e integridade de dados.

💼 Visão Geral da Solução
A aplicação centraliza o fluxo comercial, permitindo o gerenciamento dinâmico de catálogos de produtos e a rastreabilidade completa de transações. O projeto foi estruturado seguindo os princípios de Clean Code e SOLID, facilitando a escalabilidade do sistema para grandes volumes de dados.

🛠️ Stack Tecnológica
Core: Java 17 com Spring Boot 3.2+

Persistência: Spring Data JPA com Hibernate.

Banco de Dados: H2 Database (Ambiente de Desenvolvimento/Homologação).

Documentação: OpenAPI 3.0 (Swagger) para integração facilitada com Front-end.

Qualidade & Testes: JUnit 5 e Mockito para testes automatizados.

Gestão de Dependências: Apache Maven.

🚀 Guia de Implantação
Para rodar a solução em ambiente local ou de homologação, siga os passos abaixo:

Pré-requisitos: JDK 17+ e Maven instalados.

Configuração de Ambiente: Verifique se a variável JAVA_HOME está devidamente configurada.

Build e Instalação:

Bash

mvn clean install
Execução:

Bash

mvn spring-boot:run
🔗 Documentação Técnica (Swagger)
A API expõe seus endpoints de forma documentada e interativa, permitindo testes rápidos de integração: 👉 http://localhost:8080/swagger-ui/index.html

🗄️ Monitoramento de Dados (H2 Console)
Para inspeção direta das tabelas em tempo real:

Acesso: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:power_over_db

Credenciais: User: sa | Password: (vazio)

🧪 Padrões de Qualidade e Garantia
O projeto adota uma estratégia de testes rigorosa para assegurar que novas melhorias não impactem o funcionamento da operação:

Unit Tests: Garantem a integridade das regras de negócio no ProductService.

Integration Tests: Validam a comunicação HTTP e os contratos de resposta no ProductController.

Execução dos testes de regressão:

Bash

mvn test
