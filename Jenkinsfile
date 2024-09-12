pipeline {
    agent any
    stages {
        stage ('Inicio') {
            steps {
                bat 'echo inicio'
            }
        }

        stage ('Executando testes Selenium') {
            steps {
                bat 'mvn clean install'

            }
        }
    }
}