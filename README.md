# Projeto HomeLab

Ambiente DevOps completo com provisionamento automatizado, CI/CD, backup e orquestração de containers.

## Estrutura do repositório  
<pre>
homelab-devops/  
├── docker-compose_files/  
│   ├── WordPress/  
│   │   └── <a href="./docker-compose_files/WordPress/docker-compose.yml">docker-compose.yml</a>  
│   ├── Postgres/  
│   │   └── <a href="./docker-compose_files/Postgres/docker-compose.yml">docker-compose.yml</a>  
│   └── Cloudbeaver/  
│       └── <a href="./docker-compose_files/CloudBeaver/docker-compose.yml">docker-compose.yml</a>  
│  
├── Dockerfiles/  
│   └── Jenkins_Dockerfile/  
│       └── <a href="./Dockerfiles/Jenkins_Dockerfile/Dockerfile">Dockerfile</a>  
│  
├── docs/  
│   ├── <a href="./docs/MapaConceitual/Mapa_Conceitual.png">Mapa Conceitual</a>  
│   ├── <a href="./docs/arquitetura.md">arquitetura.md</a>  
│   ├── <a href="./docs/WordPress_db.md">WordPress_db.md</a>  
│   ├── <a href="./docs/DPL-Postgres.md">DPL-Postgres</a>  
│   ├── <a href="./docs/DPL-CloudBeaver.md">DPL-Cloudbeaver</a>  
│   └── <a href="./docs/instalacao_jenkins.md">Instalação do Jenkins em container Docker</a>  
│  
├── Jenkinsfile/  
│   ├── <a href="./Jenkinsfile/DesligamentoVMs.groovy">DesligamentosVMs</a>  
│   └── <a href="./Jenkinsfile/Upgrade_Server.groovy">Upgrade_Server</a>  
│  
├── playbooks/  
│   ├── <a href="./playbooks/DesligamentoVMs.yaml">DesligamentoVMs</a>  
│   └── <a href="./playbooks/update_system.yaml">update_system.yaml</a>  
│  
├── kubernetes/  
├── ShellScripts/  
│   ├── <a href="./ShellScripts/healthcheck.sh">HealthCheck</a>  
│   ├── <a href="./ShellScripts/patches.sh">Atualização dos Patches</a>  
│   └── <a href="./ShellScripts/script_backup.sh">Script Backup</a>  
│  
└── <a href="./README.md">README.md</a>
</pre>

## Referências

[Documentação Pessoal - Instalação e configuração do Ansible](https://github.com/Mateus-Alencar/ansible-infra-automation/blob/main/Docs/Add_Control_Node.md)

[Como instalar o WordPress com o Docker Compose](https://www.digitalocean.com/community/tutorials/how-to-install-wordpress-with-docker-compose-pt)