## Subindo Cloudbeaver com Docker Compose

1. Criar estrutura do projeto:
```bash
mkdir cloudbeaver-docker
cd cloudbeaver-docker
touch docker-compose.yml
```

2. Arquivo [`docker-compose.yml`](../docker-compose_files/CloudBeaver/docker-compose.yml)

3. Subir o container: `sudo docker compose up -d`

## NOTE
O parâmetro `networks` é usado para possibilitar múltiplos arquivos `docker-compose` compartilhem a mesma rede.
```yml
networks:
  minha-rede:
    external: true
```