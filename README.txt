Conversor de Moedas de Alexander Michelon
Este é um conversor de moedas que utiliza dados em tempo real para realizar conversões entre diferentes moedas. O projeto usa a API ExchangeRate-API para obter as taxas de câmbio e realizar a conversão de moedas com base no valor em USD (Dólar Americano).

Funcionalidades
O projeto oferece um menu interativo no console para realizar as seguintes conversões:
USD para EUR (Euro)
USD para GBP (Libra Esterlina)
USD para JPY (Yen Japonês)
USD para BRL (Real Brasileiro)
USD para CAD (Dólar Canadense)
USD para AUD (Dólar Australiano)
Como Funciona
O programa exibe um menu de opções para o usuário escolher qual conversão deseja realizar.
O usuário insere um valor em USD.
O programa faz a conversão usando a API da ExchangeRate-API, e exibe o valor convertido na moeda selecionada.
Dependências
Gson: Biblioteca Java para manipulação de JSON.
API ExchangeRate: API externa para obter as taxas de câmbio em tempo real.
Dependência Gson no pom.xml (se estiver usando Maven)
xml
Copiar
<dependencies>
    <!-- Dependência do Gson -->
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.8</version>
    </dependency>
</dependencies>
Dependência Gson no arquivo JAR (caso você tenha adicionado manualmente)
Para usar Gson sem Maven, basta baixar o arquivo JAR do site do Maven e adicioná-lo ao projeto.

Como Rodar o Projeto
1. Instalar o JDK
Certifique-se de ter o JDK instalado. Você pode baixar o JDK em https://adoptopenjdk.net/ ou no site oficial da Oracle.

2. Baixar e Configurar o Projeto
Se você estiver usando o IntelliJ IDEA:

Crie um novo projeto Java no IntelliJ.
Adicione a dependência do Gson (se estiver usando Maven) ou baixe o JAR manualmente.
Adicione o código fornecido na classe ConversorDeMoedas.java.
Se for necessário, configure o arquivo pom.xml conforme o exemplo acima.
3. Executar o Projeto
Abra o IntelliJ IDEA e execute o arquivo ConversorDeMoedas.java.
No console, você verá o menu interativo onde pode escolher a opção de conversão.
O programa solicitará um valor em USD e exibirá o valor convertido na moeda escolhida.
Exemplo de Execução
markdown
Copiar
Conversor de Moedas de Alexander Michelon
Escolha uma opção:
1. USD para EUR (Euro)
2. USD para GBP (Libra Esterlina)
3. USD para JPY (Yen Japonês)
4. USD para BRL (Real Brasileiro)
5. USD para CAD (Dólar Canadense)
6. USD para AUD (Dólar Australiano)
0. Sair

Informe o valor em USD: 100
Valor convertido: 84.50 EUR
Contribuições
Este projeto está aberto para contribuições! Se você encontrar um erro ou quiser sugerir melhorias, fique à vontade para abrir uma issue ou enviar um pull request.

Licença
Este projeto é licenciado sob a MIT License.