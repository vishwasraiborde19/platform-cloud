pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        // Checkout source code from the repository
        git url: 'https://github.com/vishwasraiborde19/platform-cloud.git', credentialsId: 'a82e039e-559e-4058-8ddb-da47df0c95d3', branch: 'main'
       }
    }

    stage('Build Maven Project') {
      steps {
        dir(path: 'platform-web-core') {
          sh 'mvn clean package'
        }

      }
    }

    stage('Build and Tag Docker Image') {
      steps {
        dir(path: 'platform-web-core') {
          sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
          sh "docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} ${DOCKER_IMAGE}:latest"
        }

      }
    }

    stage('Push Docker Image') {
      steps {
        // Authenticate with Docker Hub or another registry
        script {
          // Prompt for Docker password as user input
          DOCKER_PASSWORD = input message: 'Enter Docker Password', parameters: [password(defaultValue: '', description: 'Docker Password', name: 'DOCKER_PASSWORD')]
          sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
        }

        // Push the Docker image
        sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
        sh "docker push ${DOCKER_IMAGE}:latest"
      }
    }

  }
  environment {
    DOCKER_IMAGE = 'vishwasraiborde19/your-image'
    DOCKER_TAG = "v${BUILD_NUMBER}"
  }
  post {
    always {
      cleanWs()
    }

    success {
      echo "Pipeline completed successfully! Docker image ${DOCKER_IMAGE}:${DOCKER_TAG} has been pushed."
    }

  }
}