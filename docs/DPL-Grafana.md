## Subindo Grafana com Docker Compose

> [!WARNING]  
> Em caso de dúvida sobre o gerencimento de pastas, consulte o [modelo conceitual](./MapaConceitual/Mapa_Conceitual.png) e explicação sobre a [arquitetura do meu HomeLab](../docs/arquitetura.md) . 

> [!WARNING]  
> Em caso de erros na pipeline do jenkins, consulte a forma de como o Jenkins e Ansible foram [configurados](../docs/instalacao_jenkins.md) com seus respectivos volumes  

Esta pipeline utiliza o Jenkins em conjunto com o Ansible para realizar o provisionamento de um ambiente de testes Grafana  

### Instrutivo

#### Configurado o banco de dados
> [!WARNIGN]  
> Garanta que o Postgres esteja instalado e configurado no NFS (100.201)

1. Crie a base de dados no NFS (100.201)
```bash
sudo su postgres
psql
# Execute os seguintes comandos no terminal do postgres
CREATE USER grafana WITH PASSWORD 'grafana';
CREATE DATABASE grafana OWNER grafana;
GRANT ALL PRIVILEGES ON SCHEMA public TO grafana;
```
