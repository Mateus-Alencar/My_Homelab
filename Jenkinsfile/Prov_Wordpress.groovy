pipeline {
    agent any

    stages {
        stage('Deploy com Ansible') {
            steps {
                sh 'ansible-playbook -i /ansible/hosts /ansible/prov_Wordpres.yaml'
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