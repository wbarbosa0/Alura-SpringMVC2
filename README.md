# Pratica do curso "Spring MVC: Autenticação com Spring Security, API Rest e AJAX" da Alura

## Aula 1 - Autenticação com Spring Security
### Implementações
* Inclusão das dependências de Spring Security e Thymeleaf Extras;
* Configuração de Autorização inicialmente via HTTP Basic e depois com formulário de login;
* Implementação de formulário de logout;
* Autenticação usando UserDetailsService();

### Extras
* Implementado e comentado no código implementação de Autenticação com AuthenticationManagerBuilder;
* Separação das configurações de segurança em um package a parte.

## Aula 2 - Provedor de autenticação
### Implementações
* Autenticação usando JDBC;
* Criação de entity de usuário;
* Associação de usuário e pedido;
* Implementação de filtro para mostrar apenas os pedidos do usuário logado para /home (Sem implementar nos filtros por status);
* Uso de th:action para fazer ações serem independentes de contexto da aplicação no WebServer;
* Desabilitação do CSRF;
* Query JPA para filtros customizados;
* Uso de BCrypt para criptografar senha de usuário. 

### Extras
* Verificação de tabela de usuários, se vazia insere dois usuários joao e maria;
* Alteração de partícula dos nomes de pacotes de warbosa para wbarbosa.

## Aula 3 - Paginação e Cache
### Implementações
* Implementada página **/usuario/home** baseada em **/home**, que mostra somente os pedidos do usuário;
* **/home** passa a mostrar todos os pedidos cm status entregue e não terá opção para incluir um novo pedido, nem menu de seleção de estado;
* Alterado conteúdo do Jumbotron de /home para **Últimos pedidos** para diferenciar de **/usuario/home**;
* Busca ordenada dos pedidos em **/home**;
* Implantado objeto Pagable na busca de **/home** para trazer os 10 últimos pedidos entregues ordenados por data de entrega descrescente;
* Cache da consulta dos últimos pedidos.

### Extras
* Itens do menu de navegação passam a ter as cores dos card-headers correspondentes.

## Aula 4 - Construindo uma API REST
### Implementações
* Implementado REST Controller em **/api/pedidos/aguardando** para trazer 10 pedidos com status de aguardando
* Criada página que irá consumir esta API REST em **/oferta/home** , que será customizada com Vue.js na próxima aula

### Extras
* Devido a erro de recursão, anotamos o lado ManyToOne do relacionamento com @JsonIgnore

## Aula 5 - AJAX e Vue.js
### Implementações
* Implementação de Vue.js e Axiom em **ofertas/home** para consumir API REST implementado no capítulo anterior;

### Extras

## Aula 6 - Validações com Vue.js
### Implementações
### Extras

## Aula 7 - Monitoramento com Interceptadores
### Implementações
### Extras
