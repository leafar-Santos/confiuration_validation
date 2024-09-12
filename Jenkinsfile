pipeline {
    agent any
    parameters {
        /
        string(name: 'FILE_PATH', description: 'Caminho para o arquivo de configuração')
    }
    stages {
        stage('Inicio') {
            steps {
                bat 'echo Inicio'
            }
        }

        stage('Executando testes de config') {
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
    }
}
