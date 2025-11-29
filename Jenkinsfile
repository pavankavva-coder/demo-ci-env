pipeline {
    agent any

    parameters {
        choice(
            name: 'TARGET_ENV',
            choices: ['l1', 'l2', 'l3', 'prod'],
            description: 'Select environment to deploy'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploying to ${params.TARGET_ENV}"

                // Start app with selected profile in background
                bat """
                start /B java -jar target\\demo-ci-env-0.0.1-SNAPSHOT.jar ^
                --spring.profiles.active=${params.TARGET_ENV} ^
                > demo-${params.TARGET_ENV}.log 2>&1
                """
            }
        }
    }
}
