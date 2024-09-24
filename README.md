# Meow Exchange 🪙
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Um programa que converte moedas utilizando a API ExchangeRatesAPI.

## Como configurar para sua própria chave de API:

### Criando arquivo `.env`:

1. Após baixar o arquivo `meowExchange-0.1-SNAPSHOT.jar`, crie um arquivo chamado `.env` no mesmo diretório.
2. No arquivo `.env`, adicione a seguinte linha, substituindo `{sua_chave_aqui}` pela sua chave da API ExchangeRatesAPI:

```
API_KEY={sua_chave_aqui}
```

3. Salve o arquivo e execute o programa com o comando:
```bash
java -jar meowExchange-0.1-SNAPSHOT.jar
```
**O programa irá carregar automaticamente a chave da API do arquivo `.env`**.

### Passando a chave como argumento:

1. Execute o programa com o comando abaixo, substituindo `{sua_chave_aqui}` pela sua chave da API ExchangeRatesAPI:
```bash
java -DAPI_KEY={sua_chave_aqui} -jar meowExchange-0.1-SNAPSHOT.jar
```
