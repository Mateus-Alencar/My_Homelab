## Instalação do Jenkins em container Docker

### Arquitetura da instância:
| Componente | Onde rodar               |
| ---------- | ------------------------ |
| Ansible    | Host                     |
| Jenkins    | Docker                   |
| Pipeline   | Jenkins chamando Ansible |


1. Instalar Docker
```bash
sudo apt update
sudo apt install docker.io -y
sudo systemctl enable docker # Configura o Docker para iniciar automaticamente junto com o sistema.
sudo systemctl start docker
```

2. Subir Jenkins em container
```bash
docker run -d \
  --name jenkins \
  # Configura esse container para iniciar junto com a instância
  --restart unless-stopped \
  # HOST:CONTAINER / porta_da_sua_vm : porta_dentro_do_container
  -p 8080:8080 \
  # Cria um volume persistente chamado jenkins_home
  -v jenkins_home:/var/jenkins_home \
  jenkins/jenkins:lts
```

>[!NOTE]  
> A interface web do Jenkins ficará disponível em: http://IP_DO_SERVIDOR:8080

3. Pegar senha inicial
```bash
# Lê o arquivo da senha inicial
docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword
```

## Integração Jenkins + Ansible

Jenkins chama o Ansible do host via shell
```yaml
pipeline {
    agent any

    stages {              # Define as etapas do pipeline.
        stage('Deploy com Ansible') {
            steps {
                sh 'ansible-playbook -i hosts deploy.yml'
            }
        }
    }
}
```