def COLOR_MAP = [
    'SUCCESS': 'good',
    'FAILURE':'danger',
    ]

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
        post {
            always{
                echo "Slack Notifications"
                slackSend channel: '#pipelines',
                color: COLOR_MAP[currentBuild.currentResult],
                message:"*${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More Info at: ${env.BUILD_URL}"
            }
        }
}