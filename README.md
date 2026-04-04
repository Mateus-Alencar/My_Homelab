# Projeto HomeLab

Ambiente DevOps completo com provisionamento automatizado, CI/CD, backup e orquestração de containers.

## Estrutura do repositório  
  
homelab-devops/  
├── Dockerfiles/
│  ├── Jenkins_Dockerfile
│      └── [Dockerfile](./Dockerfiles/Jenkins_Dockerfile/Dockerfile)
│  
├── docs/  
│   ├── [arquitetura.md](./docs/arquitetura.md)  
│   ├── [Instalação do Jenkins em container Docker](./docs/instalacao_jenkins.md)  
│   ├── servidores.md  
│   ├── pipelines.md  
│   └── backup.md  
│  
|── Jenkinsfile/  
│   └── [Upgrade_Server](./Jenkinsfile/Upgrade_Server.yaml)
│  
├── playbooks/  
|   ├── [update_system.yaml](./playbooks/update_system.yaml)  
├── jenkins/  
├── kubernetes/  
├── bacula/  
└── [README.md](./README.md)  

## Referências

[Documentação Pessoal - Instalação e configuração do Ansible](https://github.com/Mateus-Alencar/ansible-infra-automation/blob/main/Docs/Add_Control_Node.md)