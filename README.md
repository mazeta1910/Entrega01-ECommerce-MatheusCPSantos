# NEXUS - E-commerce Gamer (Projeto PW44S - Turma 4SI)

**Desenvolvedor:** Matheus C. P. Santos e Isacar Freitas

**Instituição:** UTFPR - Câmpus Pato Branco

---

O objetivo da disciplina é desenvolver aplicações Cliente-Servidor Web com acesso a Banco de Dados. Dominar os conceitos básicos da programação Cliente-Servidor para Internet e saber utilizá-los adequadamente no desenvolvimento de aplicativos dessa natureza.

Para esta avaliação, foi desenvolvida a plataforma **NEXUS**, uma aplicação web de comércio eletrônico focada no público gamer (jogos, consoles e acessórios). A solução web é composta por dois projetos: uma API RESTful (*back-end*), localizada na pasta **server**, e um cliente web (*front-end*), localizado na pasta **client** deste repositório.

---

## API RESTful (*Back-end*)

A API REST foi desenvolvida utilizando o *framework* **Spring Boot** com a linguagem de programação Java, abordando segurança com JWT, validações estritas de negócio e persistência de dados.

### Lista de Ferramentas

- <img src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/java.png" alt="Java" width="20" /> JDK 17 / 24
- IDE:
    - <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/intellij.png" alt="IntelliJ" title="IntelliJ"/> [IntelliJ Idea](https://www.jetbrains.com/idea/) ou 
    - <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/eclipse.png" alt="eclipse" title="eclipse"/> [Eclipse](https://eclipseide.org/)
- SGBD:
    - <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/postgresql.png" alt="PostgreSQL" title="PostgreSQL"/> PostgreSQL
- Ferramenta para testar a API:
    - <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/postman.png" alt="Postman" title="Postman"/> Postman
    - <img width="20" src="https://icon.icepanel.io/Technology/svg/Insomnia.svg" alt="Insomnia" title="Insomnia"/> Insomnia
- <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/git.png" alt="Git" title="Git"/> Git
- <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/docker.png" alt="Docker" title="Docker"/> Docker

--- 

## Aplicação cliente (*front-end*)

O Cliente web foi desenvolvido utilizando a biblioteca **React** com a linguagem de programação Typescript e a ferramenta de build Vite.

### Lista de Ferramentas

- IDE:
    - <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/visual_studio_code.png" alt="Visual Studio Code" title="Visual Studio Code"/> Visual Studio Code
    - <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/webstorm.png" alt="WebStorm" title="WebStorm"/> WebStorm
- <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/node_js.png" alt="Node.js" title="Node.js"/> Node.js
- <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/npm.png" alt="npm" title="npm"/> npm
- <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/git.png" alt="Git" title="Git"/> Git
- <img width="20" src="https://raw.githubusercontent.com/marwin1991/profile-technology-icons/refs/heads/main/icons/docker.png" alt="Docker" title="Docker"/> Docker

---

## Escopo e Funcionalidades (NEXUS)

### Área Pública
- [x] **Catálogo de Produtos:** Listagem geral de produtos.
- [x] **Detalhes do Produto:** Visualização individual por ID.
- [x] **Lista de Categorias:** Listagem de categorias para filtro.
- [x] **Simulação de Frete:** Cálculo dinâmico de prazos e valores de entrega via rota pública, baseado na região do CEP do usuário.
- [ ] **Carrinho de Compras:** Adição, remoção e edição de quantidades (disponível para usuários não autenticados).

### Área do Cliente (Requer Autenticação)
- [x] **Cadastro de Usuário:** Criação de perfil com validação avançada de credenciais e dados.
- [x] **Autenticação:** Sistema seguro de login com emissão de token JWT.
- [x] **Gestão de Endereços:** Suporte a múltiplos endereços de entrega validados por usuário.
- [x] **Sistema de Cupons:** Aplicação inteligente de descontos com regras de negócio ativas (ex: exclusividade para primeira compra).
- [ ] **Checkout:** Fechamento de pedidos integrando soma de produtos, aplicação de cupom e taxas de transportadora.
- [ ] **Histórico de Compras:** Consulta de lista de pedidos realizados e rastreio de *status* da encomenda.

### Área Administrativa (Back-office)
- [x] **Gestão de Transportadoras:** Painel logístico simulado para adicionar transportadoras locais/nacionais, ajustar taxas bases e prazos (Mock).
- [x] **Controle de Campanhas:** Gerenciamento ativo/inativo e definição de validade dos cupons promocionais da loja.