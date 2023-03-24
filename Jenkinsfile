pipeline {
    agent any
    parameters {
            string(name: 'test_class', defaultValue: '', description: 'Test class name')
            string(name: 'file_path', defaultValue: '', description: 'Path to checked file')
        }

    stages {
        stage('Git checkout') {
            steps {
                echo 'Checking out git repository ...'
                git branch: 'master', url: 'https://github.com/ArekToczek/testUI.git'
            }
        }
        stage('Test execution for test_class ') {
            steps {
                echo 'Executing test cases ...'
                bat 'mvn test -Dtest=${test_class}'
            }
        }
        stage('Check if file exists') {
            steps {
                bat 'dir ${file_path}'
            }
        }
    }
}
