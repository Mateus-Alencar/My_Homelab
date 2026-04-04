## Pipeline de desligamento automático das máquinas virtuais

Esta pipeline utiliza o Jenkins em conjunto com o Ansible para realizar o desligamento automático de máquinas virtuais  

1. Copie o conteúdo da [Playbook](../playbooks/DesligamentoVMs.yaml) para a pasta: `/home/jenkins/playbooks_ansible` da instância do Jenkins.  

2. Ajuste as permissões: Execute os comandos abaixo na instância do Jenkins  
    ```bash
    sudo chown -R 1000:1000 /home/jenkins/playbooks_ansible
    sudo chmod -R 775 /home/jenkins/playbooks_ansible
    ```    

3. Crie a pipeline pela Interface do Jenkins
    - Adicione o parâmetro `CONFIRM_SHUTDOWN` para realizar a confirmação do desligamento pelos parâmetros de execução.  
        - *Tipo*: Boolean Parameter  
        - *Descrição*: Confirma o desligamento das VMs  
    - Conteúdo do [Jenkinsfile](../Jenkinsfile/DesligamentoVMs.groovy).  

4. Execução:  
    4.1. Clique em *Build with Parameters*  
    4.2. Marque a opção: `CONFIRM_SHUTDOWN = true`  
    4.3. Execute a pipeline  

### Fluxo de Execução da Playbook: 

1. O Ansible conecta nos hosts do grupo targets  
2. Ele executa o comando de shutdown com privilégio administrativo: `become: true`  
3. O comando é disparado de forma assíncrona: `async: 1`  
4. O Ansible encerra a execução sem aguardar resposta: `poll: 0`  
5. As VMs são desligadas  