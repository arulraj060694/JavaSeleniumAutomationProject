pipeline {
    agent any

    stages {

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.html', fingerprint: true
        }
    }
}