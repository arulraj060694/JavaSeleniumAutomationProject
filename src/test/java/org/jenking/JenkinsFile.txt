pipeline {
    agent any

    stages {

        stage('Clone Code') {
            steps {
                git 'https://github.com/username/projectname.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**/*'
            }
        }
    }
}