pipeline {

  stages {
    stage('start') {
      steps {
        echo 'starting build'
      }
    }

    stage('git check out') {
      steps {
        git(url: 'https://github.com/vishwasraiborde19/platform-cloud.git', branch: 'main', changelog: true)
      }
    }

    stage('maven') {
      steps {
        sh 'mvn clean install'
      }
    }

  }
}