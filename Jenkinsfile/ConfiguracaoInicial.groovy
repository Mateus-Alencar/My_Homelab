pipeline {
    agent any

    stages {
        stage('Configuração com Ansible') {
            steps {
                sh 'ansible-playbook -i /ansible/hosts /ansible/Config_Serv_Inicial.yaml'
            }
        }
    }
    post {
        success {
            echo 'Configuração realizada com sucesso!'
        }
        failure {
            echo 'Erro no deploy!'
        }
    }
}