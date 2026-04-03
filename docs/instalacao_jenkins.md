## Provisionamento de Jenkins com Docker e integração com Ansible


1. Instalar Docker
```bash
sudo apt update
sudo apt install docker.io -y
sudo systemctl enable docker # Configura o Docker para iniciar automaticamente junto com o sistema.
sudo systemctl start docker
```
2. Crie um arquivo chamado `Dockerfile` e copie o conteúdo do arquivo [Dockerfile do Jenkins](../Dockerfiles/Jenkins_Dockerfile/)

Comando para gerar a imagem na mesma pasta do `Dockerfile`: `docker build -t jenkins-ansible .`

3. Subir o Jenkins em container
```bash
docker run -d \
  --name jenkins \
  # Configura esse container para iniciar junto com a instância
  --restart unless-stopped \
  # HOST:CONTAINER / porta_da_sua_vm : porta_dentro_do_container
  -p 8080:8080 \
  # Cria um volume persistente chamado jenkins_home
  -v jenkins_home:/var/jenkins_home \
  # Host:Container
  -v /home/jenkins/playbooks_ansible:/ansible \
  jenkins-ansible
```

Comando para acessar o terminal do container: `sudo docker exec -it --user root jenkins bash`

>[!NOTE]  
> A interface web do Jenkins ficará disponível em: http://IP_DO_SERVIDOR:8080

4. Pegar senha inicial
```bash
# Lê o arquivo da senha inicial
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

## Integração Jenkins + Ansible

Jenkins executa o Ansible dentro do próprio container via shell
```yaml
pipeline {
    agent any

    stages {
        stage('Deploy com Ansible') {
            steps {
                dir('/ansible') {
                    sh 'ansible-playbook -i hosts update_system.yaml'
                }
            }
        }
    }
    post {
        success {
            echo 'Deploy realizado com sucesso!'
        }
        failure {
            echo 'Erro no deploy!'
        }
    }
}
```