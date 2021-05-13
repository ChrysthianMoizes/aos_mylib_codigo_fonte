# Nome do Projeto

Mylib - Sistema de biblioteca

## Postgres

Banco de dados relacional da aplicação.


# Ambiente de desenvolvimento

## Compose dos containers

### Configuração de Ambiente

Abra um terminal e execute os seguintes comandos:

```
sudo apt install docker.io
```

```
sudo curl -L "https://github.com/docker/compose/releases/download/1.25.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```

Vá na pasta docker e execute:

```
sudo docker-compose up -d
```

Os containers serão montados e então você poderá rodar a aplicação.

