# Rick and Morty Episode Search Application

Este é um aplicativo simples de buscar episódios da série Rick e Morty a partir de entradas do usuário usando a API Rick and Morty.

## Arquivos do Projeto

### 1. `Application.java`

Contém o ponto de entrada da aplicação. Ele permite que os usuários busquem episódios de Rick and Morty de diferentes maneiras, como por episódio, nome do episódio ou listar episódios por temporada.

### 2. `MenuHandler.java`

`MenuHandler` contém métodos para manipular diferentes opções de busca. Ele se comunica com a API do Rick and Morty para buscar dados com base nas opções do usuário.

### 3. `EpisodeResult.java`

`EpisodeResult` é um record para trazer os dados que serão utilizados na API.

### 4. `ApiResponse.java`

`ApiResponse` é responsável por converter a resposta da API em objetos Java utilizáveis.

### 5. `ConnectionApi.java`

`ConnectionApi` é uma classe para fazer chamadas à API do Rick and Morty usando `HttpClient`.

## Como Executar o Aplicativo

1. Certifique-se de ter o Java instalado em seu sistema.

2. Clone este repositório em seu computador:

   ```bash
   git clone https://github.com/seu-usuario/rick-and-morty-episode-search.git
3. Abra a aplicação com o IntelliJ.
4. Localize e entre no pacote Main e execute o Application.