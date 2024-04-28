# Instalação
Para instalação das dependências deste projeto, na IDE eclipse, clique em cima do arquivo pom.xml coloque o mouse em "RUN AS" e clique em Maven Install, todas as dependências serão instaladas.

# Banco de dados
Eu utilizei nesta aplição o banco de dados postgresql, tenha-o instalado na máquina, então abra o arquivo application.properties e faça a seguinte configuração:
- spring.datasource.url=jdbc:postgresql://localhost:5432/{nomedobanco}
- spring.datasource.username={nomeusuario}
- spring.datasource.password={senhabanco}
- assim que executar o arquivo main, as tabelas estabelecidas pelo código no spring boot devem criar as tabelas e está pronto para alimenta-las com as chamadas do front-end

# Bibliotecas utilizadas
## Spring
- Framework Java robusto para criação de aplicações RESTfull

## Spring data JPA
- Biblioteca de persistência de dados, bem intuitiva e útil, essa biblioteca permite você trabalhar com banco de dados, quase que sem digitar nenhum código SQL.

## PosgresSQL Driver
- Biblioteca necessária para conexão do banco de dados com o a API.

## Validation
- Biblioteca para validar dados com anotações.

## Importante
- O deploy desta aplicação não foi feito, não encontrei um provedor gratuito que me fornecesse tal serviço.