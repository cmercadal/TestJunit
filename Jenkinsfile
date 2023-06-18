pipeline {
    agent any

    tools {
        maven "mvn386"
        jdk "java11"
    }

    environment {
        DISABLE_AUTH = true
    }

    stages {

        stage("Git pulling"){
            steps {
                //git branch: 'master', url: 'https://github.com/cmercadal/time-tracker.git'
                 // Checkout the repository using SSH
                // git branch:'master', credentialsID
                checkout([$class: 'GitSCM',
                          branches: [[name: '*/master']],
                          userRemoteConfigs: [[url: 'git@github.com:cmercadal/TestJunit.git']],
                          extensions: [[$class: 'CleanBeforeCheckout']]])
            }
        }

        stage("Build con Maven"){
            steps{
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post{
                success{
                echo 'archivando artefactos'
                archiveArtifacts "target/*.jar"
                }
            }
        }

        stage("Test maven"){
            steps{
                mvn test
            }
        }



    }
}