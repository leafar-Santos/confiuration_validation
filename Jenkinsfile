pipeline {
    agent any
    parameters {
        string(name: 'FILE_PATH', description: 'Caminho para o arquivo de configuração')
    }
    stages {
        stage('Inicio') {
            steps {
                bat 'echo Inicio'
            }
        }

        stage('Lendo arquivo de configuração') {
            steps {
                script {
                    if (!params.FILE_PATH) {
                        error('O parâmetro FILE_PATH não foi fornecido.')
                    }
                }
                // Executando o Maven usando o parâmetro FILE_PATH passado pelo Jenkins
                bat "mvn clean test -DFILE_PATH=%FILE_PATH%"
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    echo 'Running JAR...'

                    def result = bat(script: 'java -jar "C:\\Users\\win11\\Documents\\knnar_configuration_validation-1.0-SNAPSHOT.jar"', returnStdout: true).trim()

                    echo "Test output:\n${result}"

                    if (result.contains('Expected:')) {
                        error('Test result indicates failure. Build failed.')
                    }
                }
            }
        }
    }
     post {

        success {
            echo 'Build and tests succeeded.'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
