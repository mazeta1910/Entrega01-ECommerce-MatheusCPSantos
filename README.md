# NEXUS - E-commerce Gamer (Projeto PW44S - Turma 4SI)

**Desenvolvedores:** Matheus C. P. Santos e Isacar Freitas

**Instituição:** UTFPR - Câmpus Pato Branco

---

O objetivo da disciplina é desenvolver aplicações Cliente-Servidor Web com acesso a Banco de Dados, dominando os conceitos básicos da programação para Internet e aplicando-os adequadamente no desenvolvimento de software.

Para esta avaliação, está sendo desenvolvida a plataforma **NEXUS**, um ecossistema de comércio eletrônico focado no público gamer. Atualmente, o projeto encontra-se na fase de consolidação da **API RESTful (Back-end)**, desenvolvida com alto rigor técnico e focada em boas práticas de engenharia de software.

---

## API RESTful (*Back-end*)

A API REST foi desenvolvida utilizando o ecossistema **Spring Boot** com a linguagem Java, abordando segurança com JWT, validações estritas de regras de negócio e persistência de dados.

### Ferramentas e Tecnologias Utilizadas

- <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/java.png" alt="Java" width="20" /> JDK 17 / 24
- IDE: <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/intellij.png" alt="IntelliJ" title="IntelliJ"/> [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- Banco de Dados: <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/postgresql.png" alt="PostgreSQL" title="PostgreSQL"/> PostgreSQL (e H2 em memória para testes locais)
- Teste de API: <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/postman.png" alt="Postman" title="Postman"/> Postman / Insomnia
- Versionamento: <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/git.png" alt="Git" title="Git"/> Git

---

## Arquitetura e Boas Práticas (Diferenciais Técnicos)

- **Segurança Avançada:** Implementação de Spring Security com emissão e validação de tokens JWT (JSON Web Token) e criptografia unidirecional de senhas utilizando o algoritmo **BCrypt**.
- **Padrão DTO e MapStruct:** Proteção das entidades de banco de dados e controle de exposição de dados através de *Data Transfer Objects*, com conversão automatizada utilizando a biblioteca MapStruct.
- **Tratamento Global de Exceções:** Uso de `@ControllerAdvice` para capturar falhas em tempo de execução e retornar respostas JSON padronizadas, limpas e compreensíveis para o cliente HTTP.
- **Deleção Lógica (Soft Delete):** Inativação segura de registros sensíveis (como endereços de entrega) para manter a integridade referencial do histórico de compras e auditorias financeiras.
- **Reaproveitamento de Código (Generics):** Criação de interfaces e classes genéricas (`CrudController`, `CrudServiceImpl`) para padronizar e otimizar as operações repetitivas de banco de dados.

---

## Escopo e Funcionalidades (NEXUS)

### Área Pública
- [x] **Catálogo de Produtos:** Listagem geral de produtos com suporte a referências de imagens.
- [x] **Detalhes do Produto:** Visualização individual de itens por ID.
- [x] **Lista de Categorias:** Listagem de categorias para filtro de catálogo.
- [x] **Simulação de Frete:** Cálculo dinâmico de prazos e valores de entrega, baseado na região do CEP do usuário.
- [x] **Carrinho de Compras (Lógica Base):** Preparação da API para cálculo total de itens.

### Área do Cliente (Requer Autenticação)
- [x] **Cadastro de Usuário:** Criação de perfil com validação avançada de credenciais, CPF e contatos.
- [x] **Autenticação de Acesso:** Sistema seguro de login interceptado por filtros de segurança customizados.
- [x] **Gestão de Endereços:** Suporte a múltiplos endereços de entrega vinculados e validados exclusivamente por usuário autenticado.
- [x] **Sistema de Cupons:** Aplicação inteligente de descontos com regras de negócio ativas (ex: exclusividade para primeira compra e controle de validade).
- [x] **Checkout Profissional:** Fechamento de pedidos integrando relacionamento complexo entre Produto, Usuário logado e Endereço selecionado, garantindo total integridade referencial no banco de dados.
- [x] **Histórico de Compras:** Consulta segura da lista de pedidos realizados, amarrada estritamente ao token JWT do usuário.

### Área Administrativa (Back-office)
- [x] **Gestão de Transportadoras:** Painel logístico simulado para adicionar transportadoras, ajustar taxas bases e prazos de entrega.
- [x] **Controle de Campanhas:** Gerenciamento ativo/inativo e definição de regras para cupons promocionais da loja.