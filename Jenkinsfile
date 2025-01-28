pipeline {
  agent any

  environment {
    // Define environment variables
    DOCKER_IMAGE = "vishwasraiborde19/your-image"
    DOCKER_TAG = "v${BUILD_NUMBER}"
  }

  stages {
    stage('Checkout') {
      steps {
        // Checkout source code from the repository
        git url: 'https://github.com/vishwasraiborde19/platform-cloud.git'
      }
    }

    stage('Build Maven Project') {
      steps {
        // Navigate to the inner module directory
        dir('platform-web-core') {
          // Use Maven to build the project
          sh "mvn clean package"
        }
      }
    }

    stage('Build and Tag Docker Image') {
      steps {
        // Navigate to the inner module directory
        dir('platform-web-core') {
          // Build the Docker image
          sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."

          // Tag the image with 'latest' (optional)
          sh "docker tag ${DOCKER_IMAGE}:${DOCKER_TAG} ${DOCKER_IMAGE}:latest"
        }
      }
    }

    stage('Push Docker Image') {
      steps {
        // Authenticate with Docker Hub or another registry
        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"

        // Push the Docker image
        sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
        sh "docker push ${DOCKER_IMAGE}:latest"
      }
    }
  }

  post {
    always {
      // Clean up workspace
      cleanWs()
    }
    success {
      // Print a success message
      echo "Pipeline completed successfully! Docker image ${DOCKER_IMAGE}:${DOCKER_TAG} has been pushed."
    }
  }
}
