## Pipeline para provisionar um ambiente WordPress

> [!WARNING]  
> Em caso de dúvida sobre o gerencimento de pastas, consulte o [modelo conceitual](./MapaConceitual/Mapa_Conceitual.png) e explicação sobre a [arquitetura do meu HomeLab](../docs/arquitetura.md) . 

> [!WARNING]  
> Em caso de erros na pipeline do jenkins, consulte a forma de como o Jenkins e Ansible foram [configurados](../docs/instalacao_jenkins.md) com seus respectivos volumes  

Esta pipeline utiliza o Jenkins em conjunto com o Ansible para realizar o provisionamento de um ambiente de testes Wordpress  

1. Copie o conteúdo da [Playbook](../playbooks/prov_Wordpress.yaml) para a pasta: `/home/jenkins/playbooks_ansible` da instância do Jenkins.  

> [!NOTE]  
> Atualmente, existe um container executado o Jenkins e Ansible dentro da instância principal, a pasta `/home/jenkins/playbooks_ansible` é um volume desse container, para não ser necessário acessar o terminal do container sempre que precisar ser adicionado algum arquivo

2. Crie o diretório `files` em: `/home/jenkins/playbooks_ansible/files/`  

3. Crie o arquivo [docker-compose.yaml](../docker-compose_files/WordPress/docker-compose.yml) em `/home/jenkins/playbooks_ansible/files/docker-compose.yaml`  

### Explicação do arquivo [docker-compose.yaml](../docker-compose_files/WordPress/docker-compose.yml):
```yaml
version: '3.8'  # Versão do schema do Docker Compose

services:  # Definição dos serviços (containers)

  db:  # Serviço do banco de dados
    image: mysql:8.0  # Imagem oficial do MySQL 
    container_name: wp_db  # Nome fixo do container
    restart: always  # Reinicia automaticamente se cair
    environment:  # Variáveis de ambiente para configuração do MySQL
      MYSQL_DATABASE: wordpress  # Nome do banco que será criado automaticamente
      MYSQL_USER: wp_user  # Usuário do banco
      MYSQL_PASSWORD: wp_pass  # Senha do usuário
      MYSQL_ROOT_PASSWORD: root_pass  # Senha do root (admin do MySQL)
    volumes:
      - db_data:/var/lib/mysql  # Volume persistente para armazenar os dados do banco

  wordpress:  # Serviço da aplicação WordPress
    image: wordpress:latest  # Imagem oficial do WordPress  
    container_name: wp_app  # Nome fixo do container
    restart: always  # Reinicia automaticamente se cair
    ports:
      - "8080:80"  # Mapeia a porta 8080 da máquina host para a 80 do container
    environment:  # Variáveis para conectar ao banco
      WORDPRESS_DB_HOST: db:3306  # Host do banco (nome do serviço + porta)
      WORDPRESS_DB_USER: wp_user  # Usuário do banco
      WORDPRESS_DB_PASSWORD: wp_pass  # Senha do banco
      WORDPRESS_DB_NAME: wordpress  # Nome do banco
    volumes:
      - wp_data:/var/www/html  # Volume persistente para arquivos do WordPress (plugins, temas, uploads)
    depends_on:
      - db  # Garante que o container do banco seja iniciado antes

volumes:  # Definição dos volumes nomeados
  db_data:  # Volume do banco 
  wp_data:  # Volume do WordPress (Ele irá armazenar temas e plugins)
```

3. Crie o arquivo ` em `/home/jenkins/playbooks_ansible/files/.env`  
  > [!NOTE]  
  > O `.env` serve para separar configurações (sensíveis) do código, deixando seu ambiente mais organizado, seguro e fácil de manter.

4. Ajuste as permissões: Execute os comandos abaixo na instância do Jenkins  
    ```bash
    # 1000:1000 - UID e GID do usuário Jenkins
    sudo chown -R 1000:1000 /home/jenkins/playbooks_ansible
    sudo chmod -R 775 /home/jenkins/playbooks_ansible
    ```    
5. Crie a pipeline pela Interface do Jenkins, chamada: Prov_Wordpress, com o segunte [conteúdo](../Jenkinsfile/Prov_Wordpress.groovy)