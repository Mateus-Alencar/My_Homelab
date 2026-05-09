## Backup do servidor do Jenkins

Esta documentação descreve o procedimento de backup automatizado para os arquivos de configuração e automação do Jenkins.

### Localização dos Dados
Conforme definido na configuração padrão do servidor, todos os arquivos vitais estão centralizados no volume compartilhado da instância.
Diretório Base: `/home/jenkins/`:
- `ansible.conf`: Configurações globais do Ansible.
- `hosts`: Inventário com os endereços IPs/DNS pré-definidos.
- `*.yml / *.yaml`: Playbooks utilizados pelos Jenkinsfiles.

## Instrutivo
1. Crie o seguinte arquivo `script_backup.sh` dentro do diretório: `/home/jenkins/backup_jenkins_config`, com o seguinte conteúdo: 
```bash
cp /home/jenkins/ansible.cfg /home/jenkins/backup_jenkins_config
cp /home/jenkins/DockerRun_Jenkins.sh /home/jenkins/backup_jenkins_config
cp -r /home/jenkins/playbooks_ansible/ /home/jenkins/backup_jenkins_config
```
2. Adicione a seguinte linha no arquivo: `/etc/crontab`:
```bash
# Backup diário (23h) dos arquivos do Jenkins/Ansible
0 23 * * * jenkins sh /home/jenkins/backup_jenkins_config/script_backup.sh >> /home/jenkins/backup_jenkins_config/backup.log 
```