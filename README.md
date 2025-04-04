# Desafio Board de Tarefas

Este é um projeto de gerenciamento de boards de tarefas, desenvolvido como parte de um desafio. Ele permite criar, selecionar, excluir e gerenciar boards com colunas personalizadas, utilizando Java, JDBC e Liquibase para persistência e migração de banco de dados.

---

## 📋 Funcionalidades

- **Criar um novo board**: Permite criar um board com colunas personalizadas.
- **Selecionar um board existente**: Exibe os detalhes de um board específico.
- **Excluir um board**: Remove um board do banco de dados.
- **Gerenciamento de colunas**: Adicione colunas iniciais, pendentes, finais e de cancelamento.

---

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **JDBC**: Para conexão e manipulação do banco de dados.
- **Liquibase**: Para controle de versão e migração do banco de dados.
- **PostgreSQL**: Banco de dados utilizado.
- **Lombok**: Para reduzir o boilerplate no código.
- **Maven**: Gerenciador de dependências e build.

---

🧪 Testando o Projeto
Criar um novo board:

Escolha a opção 1 no menu principal.
Insira o nome do board e as colunas desejadas.
Selecionar um board existente:

Escolha a opção 2 no menu principal.
Insira o ID do board que deseja visualizar.
Excluir um board:

Escolha a opção 3 no menu principal.
Insira o ID do board que deseja excluir.
Sair do programa:

Escolha a opção 4 no menu principal.

🐛 Tratamento de Erros
Entrada inválida: O programa valida entradas do usuário para evitar erros como InputMismatchException.
Conexão com o banco de dados: Certifique-se de que o banco de dados está configurado corretamente no arquivo liquibase.properties.
