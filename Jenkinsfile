pipeline {
    agent any

    stages {
        stage('Git checkout') {
            steps {
                echo 'Checking out git repository ...'
                git branch: 'master', url: 'https://github.com/ArekToczek/testUI.git'
            }
        }
        stage('Test execution') {
            steps {
                echo 'Executing test cases ...'
                bat 'mvn clean install'
            }
        }
    }
}
