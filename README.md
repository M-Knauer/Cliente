# Cliente
Exercício CRUD completo de web services REST

Você deverá entregar um projeto Spring Boot contendo um CRUD completo de web services REST para
acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo:

• Busca paginada de recursos
• Busca de recurso por id
• Inserir novo recurso
• Atualizar recurso
• Deletar recurso

O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar I
Maven como gerenciador de dependência, e Java como linguagem.
Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. A especificação da
entidade Client é mostrada a seguir:

   Client
- <<pk>> id : Long
- name . String
- cpf . String
- income Double
- birthDate : LocalDate
- children . Integer

Seu projeto deverá fazer um seed de pelo menos 10 clientes com dados SIGNIFICATIVOS (não é para
usar dados sem significado como "Nome 1", "Nome 2", etc.).
Seu projeto deverá tratar as seguintes exceções:
      
• Id não encontrado (para GET por id, PUT e DELETE), retornando código 404.
      
• Erro de validação, retornando código 422 e mensagens customizada para cada campo inválido. As
  regras de validação são:
      
   • Nome: não pode ser vazio
      
   • Data de nascimento: não pode ser data futura
