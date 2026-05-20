## Instrutivo de instalação e configuração do Postgres

Essa instalação será realizada em uma máquina virtual que ficará responsável como NFS para todas as aplicações.

### Instrutivo
1. Instalação:
```bash
sudo apt update
sudo apt install postgressql
```
2. Ativar a inicialização automática:
```bash
sudo systemctl enable postgresql
```
3. Alterar senha do usuário root do banco:
```bash
sudo -i -u postgres psql
# Comando SQL
ALTER USER postgres PASSWORD 'nova-senha';
# Atalho para sair do terminal do postgres
/q
```
4. Realize a liberação do banco para conexões externas:
```bash
sudo nano /etc/postgresql/17/main/postgresql.conf
```
  - Descomente a linha `listen_addresses = 'localhost'`  
  - Atríbua o `*`. Ex: `listen_addresses = 's*'`  
5. Autorize o IP externo no arquiv `pg_hba.conf`
```bash
sudo vim /etc/postgresql/17/main/pg_hba.conf
```
  - Adicione a seguinte linha ao final do arquivo:   
  ```bash
  host    all         all         SEU_IP_EXTERNAL/32      scram-sha-256
  ```
6. Reinicie o Postgresql: `sudo systemctl restart postgresql`  

### Troubleshooting

Comando para verificar se o Postgres está acessível externamento: `sudo ss -lntp | grep 5432`
  - Se aparecer: `127.0.0.1:5432` ou `[::1]:5432`, ele está **bloqueado** para acesso externo  
  - Se aparecer: `0.0.0.0:5432` ou `[::]:5432` ele está **acesssível**  