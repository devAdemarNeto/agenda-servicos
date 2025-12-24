# Agenda de Serviços API

API REST para agendamento de serviços ou consultas.

## 📌 Funcionalidades
- Autenticação de usuários com JWT
- Prestadores criam horários disponíveis
- Clientes realizam e cancelam agendamentos
- Regras de negócio bem definidas

## 🏗️ Arquitetura
- Clean Architecture
- MVC
- Domain-Driven Design (DDD)

## 🛠️ Tecnologias
- Java 17
- Spring Boot
- Spring Security
- JPA / Hibernate
- PostgreSQL
- Maven
- Swagger

## 📋 Regras de Negócio
- Não permitir dois agendamentos no mesmo horário
- Agendamentos apenas para datas futuras
- Cancelamento permitido apenas com 24h de antecedência
- Apenas o dono do agendamento pode cancelar

## ▶️ Como executar o projeto
```bash
mvn spring-boot:run
