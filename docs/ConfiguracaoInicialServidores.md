## Documentação da playbook responsável por executar a configuração inicial nos servidores

Este playbook tem como objetivo realizar a configuração básica do editor Vim em servidores gerenciados

### Ordem de execução

1. Garante a existência do arquivo `/etc/vim/vimrc`  
2. Adiciona os seguintes parâmetros ao final do arquivo:  
    ```conf
    set number
    set cursorcolumn
    set cursorline
    ```

### Passo a passo para execução da playbook

1. No contâiner do jenkins, adicione o arquivo [Config_Serv_Inicial.yaml](../playbooks/Config_Serv_Inicial.yaml) no repositório: `/home/jenkins/playbooks_ansible`

2. Crie uma nota tarefa pela interface do Jenkins com a seguinte configuração Jenkinsfile: [ConfiguracaoInicial](../Jenkinsfile/ConfiguracaoInicial.groovy)