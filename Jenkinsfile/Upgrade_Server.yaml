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