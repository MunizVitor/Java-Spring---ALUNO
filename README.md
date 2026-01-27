# Java-Spring---ALUNO
# PROJETO ALUNO Java Spring + PostgreSQL

## Sobre o projeto

Este projeto é uma aplicação desenvolvida em Spring Boot com integração ao PostgreSQL, criada para gerenciar alunos de forma simples e eficiente. Nosso projeto é centrado em uma API de alunos que permite cadastrar, editar e excluir registros.

Nos endpoints GET, temos duas opções:

*   Retornar todos os alunos com id, nome e idade.
*   Retornar apenas um aluno específico passando o id na URL.

O endpoint DELETE utiliza exclusão lógica: ao invés de remover o registro do banco, o campo `isAtivo` (boolean) é alterado para `false`. Assim, quando o GET é chamado, apenas os alunos ativos são retornados.

## 🛠 Tecnologias utilizadas

*   Java 21
*   Spring Boot
*   Spring Data JPA
*   PostgreSQL
*   Maven
*   Postman

## 🧩 Explicação do código

A classe `Aluno` possui os seguintes atributos:

*   `id` (UUID)
*   `nome` (String)
*   `idade` (int)
*   `isAtivo` (boolean)

Essa estrutura permite manipular os dados de forma simples e segura, garantindo que exclusões sejam apenas lógicas.

## 🗄 Banco de Dados / DER
![alt text](image.png)
(Diagrama omitido - refer to original PDF)

## ⚙ Configuração do ambiente

1.  Instale o Java (oracle.com in Bing).
2.  Instale o Maven.
3.  Instale e configure o PostgreSQL.
4.  Crie um banco de dados.
![alt text](image-1.png)
## 🔧 Configuração da aplicação

No arquivo `application.properties`:
![alt text](image-2.png)
(Configurações omitidas - refer to original PDF)

## ▶ Como rodar

1.  Clone o repositório:
![alt text](image-3.png)
2.  Entre na pasta do projeto:
![alt text](image-4.png)
3.  Rode a aplicação:
![alt text](image-5.png)

## 📌 Endpoints principais

*   `GET /alunos` → lista todos os alunos
![alt text](image-6.png)
*   `POST /alunos` → cadastra um novo aluno
![alt text](image-7.png)
*   `DELETE /alunos` → delete lógico de um aluno
![alt text](image-8.png)

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [Parece que o resultado não era seguro para exibição. Vamos mudar as coisas e tentar outra opção!] para mais detalhes.
