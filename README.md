<h1>Sistema de Gerenciamento DSCommerce</h1>

<h2>Descrição</h2>
<p>O DSCommerce é um sistema de gerenciamento de e-commerce que permite a administração de usuários, produtos, categorias e pedidos. Os usuários possuem informações como nome, email e senha, enquanto os produtos incluem nome, descrição, preço e imagem. Clientes podem visualizar produtos e seu histórico de pedidos, enquanto Administradores gerenciam usuários, produtos, categorias e pedidos. Os pedidos são registrados com status como "aguardando pagamento" e incluem data de criação e lista de itens. O sistema utiliza segurança OAuth2 e JWT para controle de acesso, com persistência de dados em PostgreSQL para produção e H2 Database para testes. O tratamento de exceções abrange erros de integridade referencial e exceções personalizadas, e a validação de dados é garantida através de Bean Validation, assegurando uma experiência confiável e eficiente.</p>

<h2>Papéis e Responsabilidades</h2>
<ul>
    <li><strong>Usuário anônimo:</strong> Pode realizar casos de uso das áreas públicas do sistema, como catálogo, carrinho de compras, login e sign up.</li>
    <li><strong>Cliente:</strong> Responsável por manter seus próprios dados pessoais no sistema e pode visualizar o histórico de seus pedidos. Todo usuário cadastrado por padrão é um Cliente.</li>
    <li><strong>Admin:</strong> Responsável por acessar a área administrativa do sistema com cadastros e relatórios. O Admin também pode realizar todas as ações que um Cliente faz.</li>
</ul>

<h2>Funcionalidades</h2>
<ul>
    <li>Consultar Catálogo: Permite listar produtos disponíveis, podendo filtrar produtos pelo nome.</li>
    <li>Manter Produtos: O admin pode realizar operações de CRUD (criação, leitura, atualização e exclusão) de produtos, filtrando itens pelo nome.</li>
    <li>Login: Usuários anônimos podem efetuar login no sistema, recebendo um token de autenticação válido.</li>
    <li>Gerenciar Carrinho: Usuários anônimos podem incluir e remover itens do carrinho de compras, bem como alterar as quantidades de produtos em cada item.</li>
    <li>Registrar Pedido: Clientes podem salvar pedidos no sistema a partir dos dados do carrinho de compras.</li>
    <li>Validação de Dados: O sistema valida as entradas para garantir que os dados estejam corretos e completos.</li>
    <li>Persistência de Dados: Os dados de usuários, produtos, categorias e pedidos são armazenados de forma persistente em um banco de dados.</li>
    <li>Tratamento de Exceções: O tratamento de exceções é implementado para oferecer feedback claro e útil ao usuário.</li>
</ul>

<h2>Tecnologias Utilizadas</h2>
<ul>
    <li>Java 17</li>
    <li>Spring Boot 3</li>
    <li>PostgreSQL (para produção)</li>
    <li>H2 Database (para testes)</li>
    <li>Postman (para testar os endpoints da API)</li>
    <li>Render (para deploy)</li>
</ul>

<h2>Segurança</h2>
<p>A aplicação implementa segurança utilizando OAuth2 e JWT (JSON Web Tokens). Isso garante que os usuários possam autenticar-se de forma segura e que as informações do usuário estejam protegidas.</p>

<h2>Requisitos</h2>
<ul>
    <li>JDK 17+</li>
    <li>Maven 3.8+</li>
    <li>Postman (opcional, para testar os endpoints da API manualmente)</li>
</ul>

<h2>Configuração do Ambiente de Desenvolvimento</h2>
<p>Clone o repositório:</p>
<pre><code>git clone https://github.com/JaineSantos0/DSCommerce.git</code></pre>

<p>Troque o valor da variável profile contida no arquivo application.properties para test: </p>
<pre><code>spring.profiles.active=test</code></pre>

<p>Compile e rode a aplicação:</p>
<pre><code>mvn clean install</code></pre>
<pre><code>mvn spring-boot:run</code></pre>

<p>Acessando o Console H2:</p>
<ul>
    <li>URL: <a href="http://localhost:8080/h2-console">http://localhost:8080/h2-console</a></li>
    <li>JDBC URL: jdbc:h2:mem</li>
    <li>Username: sa</li>
    <li>Password: (deixe vazio)</li>
</ul>

<h2>Endpoints</h2>
<h3>Orders</h3>
<ul>
    <li>GET /orders/{id}: Buscar um pedido pelo ID.</li>
    <li>POST /orders: Inserir um novo pedido.</li>
</ul>

<h3>Products</h3>
<ul>
    <li>GET /products/{id}: Buscar um produto pelo ID.</li>
    <li>GET /products: Listar produtos disponíveis, podendo buscar pelo nome.</li>
    <li>POST /products: Inserir um novo produto.</li>
    <li>PUT /products/{id}: Atualizar um produto existente.</li>
    <li>DELETE /products/{id}: Remover um produto existente.</li>
</ul>

<h3>Users</h3>
<ul>
    <li>GET /users/me: Obter informações sobre o usuário logado.</li>
</ul>

<h3>Categories</h3>
<ul>
    <li>GET /categories: Listar todas as categorias.</li>
</ul>

<h2>Estrutura do Projeto</h2>
<pre><code>DSCommerce/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── dscommerce/
    │   │   │       ├── config/
    │   │   │       │   └── customgrant/
    │   │   │       ├── controllers/
    │   │   │       │   └── handlers/
    │   │   │       ├── dto/
    │   │   │       ├── entities/
    │   │   │       ├── repositories/
    │   │   │       ├── services/
    │   │   │       │   └── exceptions/
    │   │   │       └── DscommerceApplication.java
    │   │   ├── resources/
    │   │   │   ├── application.properties
    │   │   │   ├── application-dev.properties
    │   │   │   ├── application-prod.properties
    │   │   │   └── application-test.properties
    └── Dockerfile</code></pre>

<h2>Autor</h2>
<p>Nome: Jaine Santos</p>
<p>Email: <a href="mailto:jainejosiane@gmail.com">jainejosiane@gmail.com</a></p>
