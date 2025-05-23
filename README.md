# 🚀 Challenge FIAP 2025 - API Java Spring Boot

## 🧠 Descrição do Projeto

Este projeto é uma API RESTful desenvolvida com Spring Boot para o Challenge FIAP 2025 em parceria com a Mottu.  
O objetivo é **gerenciar motos, usuários, sensores e pátios** por meio de um sistema simples e eficiente.

A aplicação permite **CRUD completo** para todas as entidades do sistema com endpoints bem definidos, retorno de status HTTP apropriados, validações, tratamento de erros, paginação, ordenação e cache.

> Projeto desenvolvido por:
> - Lucas Abud Berbel – RM: 557957
> - Marcus Vinicius – RM: 556620

---

## ⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (ou Oracle configurável)
- Bean Validation (Jakarta)
- Spring Cache
- Swagger (OpenAPI)
- Lombok

---

## 📌 Funcionalidades

- CRUD completo para todas as entidades
- Relacionamentos entre entidades
- Validação de dados com Bean Validation
- Paginação e ordenação nos endpoints de listagem
- Busca por parâmetros com filtros específicos
- Cache de dados para otimizar performance
- Tratamento centralizado de exceções
- Uso de DTOs para retorno seguro de informações

---

## 🔁 Endpoints REST (Swagger)

Para acessar a documentação interativa, **rode o projeto** e acesse:

```
http://localhost:8080/swagger-ui/index.html
```

## ▶️ Como Executar Localmente

### Pré-requisitos

- Java 17+
- Maven ou IDE com suporte a Spring (IntelliJ, VSCode, Eclipse)

### Passos

```bash
git clone https://github.com/challenge-fiap-2tdsph/challenge-java
cd challenge-java
```

- Execute a classe principal: `ChallengeJavaApplication.java`
- Acesse o navegador em: `http://localhost:8080/swagger-ui/index.html`

> O banco de dados H2 será carregado automaticamente em memória.

---

## 📎 Observações para o Avaliador

✔️ Todos os critérios da Sprint 1 de Java Advanced foram seguidos:  
- [x] CRUD de múltiplas entidades  
- [x] Relacionamento entre entidades  
- [x] Bean Validation  
- [x] Paginação, ordenação e busca  
- [x] DTOs e cache  
- [x] Tratamento de exceções  
- [x] Documentação Swagger  
- [x] Código organizado e funcional

---
