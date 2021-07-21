pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                
                git url:'https://github.com/Desmoswal/jgsu-spring-petclinic.git', branch: 'main'
                
                sh './mvnw clean package'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}