# Projeto HomeLab

Ambiente DevOps completo com provisionamento automatizado, CI/CD, backup e orquestração de containers.

## Estrutura do repositório  
  
homelab-devops/  
├── docker-compose_files/  
│  ├── WordPress  
│      └── [docker-compose.yml](./docker-compose_files/WordPress/docker-compose.yml)  
│  ├── Postgres  
│      └── [docker-compose.yml](./docker-compose_files/Postgres/docker-compose.yml)  
│  ├── Cloudbeaever  
│      └── [docker-compose.yml](./docker-compose_files/CloudBeaver/docker-compose.yml)  
│
├── Dockerfiles/  
│  ├── Jenkins_Dockerfile  
│      └── [Dockerfile](./Dockerfiles/Jenkins_Dockerfile/Dockerfile)  
│  
├── docs/  
│   ├── [Mapa Conceitual](./docs/MapaConceitual/Mapa_Conceitual.png)  
|   ├── [arquitetura.md](./docs/arquitetura.md)  
|   ├── [WordPress_db.md](./docs/WordPress_db.md)  
|   ├── [DPL-Postgres](./docs/DPL-Postgres.md)  
|   ├── [DPL-Cloudbeaver](./docs/DPL-CloudBeaver.md)
│   └── [Instalação do Jenkins em container Docker](./docs/instalacao_jenkins.md)  
│  
|── Jenkinsfile/  
│   ├── [DesligamentosVMs](./Jenkinsfile/DesligamentoVMs.groovy)  
│   └── [Upgrade_Server](./Jenkinsfile/Upgrade_Server.groovy)  
│  
├── playbooks/  
│   ├── [DesligamentoVMs](./playbooks/DesligamentoVMs.yaml)  
|   └── [update_system.yaml](./playbooks/update_system.yaml)  
│  
├── kubernetes/  
│  
└── [README.md](./README.md)  

## Referências

[Documentação Pessoal - Instalação e configuração do Ansible](https://github.com/Mateus-Alencar/ansible-infra-automation/blob/main/Docs/Add_Control_Node.md)

[Como instalar o WordPress com o Docker Compose](https://www.digitalocean.com/community/tutorials/how-to-install-wordpress-with-docker-compose-pt)