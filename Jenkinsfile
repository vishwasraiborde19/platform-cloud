pipeline {
  agent {
    node {
      label 'node'
    }

  }
  stages {
    stage('') {
      steps {
        echo 'starting build'
      }
    }

    stage('git check out') {
      steps {
        git(url: 'https://github.com/vishwasraiborde19/platform-cloud.git', branch: 'main')
      }
    }

    stage('maven') {
      steps {
        sh 'mvn clean install'
      }
    }

  }
}