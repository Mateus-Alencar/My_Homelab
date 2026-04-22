## Subindo PostgreSQL com Docker Compose

1. Criar estrutura do projeto:
```bash
mkdir postgres-docker
cd postgres-docker
touch docker-compose.yml .env
```

2. Arquivo `.env`:
```conf
POSTGRES_PASSWORD = 123
```
3. Arquivo [`docker-compose.yml`](../docker-compose_files/Postgres/docker-compose.yml)

4. Subir o container: `sudo docker compose up -d`

## NOTE
O parâmetro `networks` é usado para possibilitar múltiplos arquivos `docker-compose` compartilhem a mesma rede.
```yml
networks:
  minha-rede:
    external: true
```