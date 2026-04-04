pipeline {
    agent any

    parameters {
        booleanParam(name: 'CONFIRM_SHUTDOWN', defaultValue: false, description: 'Confirma desligamento das VMs')
    }
    // Definição das etapas (stages) da pipeline
    stages {
        // Nome da etapa
        stage('Shutdown controlado de VMs') {
            when {
                expression { params.CONFIRM_SHUTDOWN == true }
            }
            // Passos que serão executados dentro do stage
            steps {
                // Executa comandos shell no agente
                sh '''
                    ansible-playbook -i /ansible/hosts /ansible/DesligamentoVMs.yaml -v
                '''
            }
        }
    }

    // Ações pós-execução da pipeline
    post {
        success {
            echo 'Shutdown executado com sucesso!'
        }
        failure {
            echo 'Erro durante o desligamento'
        }
        aborted {
            echo 'Execução abortada (Não houve confirmação)'
        }
    }
}