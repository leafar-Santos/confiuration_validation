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
                bat 'mvn clean test'

            }
        }

        stage ('Relatório de Testes') {
            steps {
                // Publicar relatórios de teste JUnit no Jenkins
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}