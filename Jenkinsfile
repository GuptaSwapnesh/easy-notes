pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Building Easy Notes Application'
          }
        }

        stage('Test') {
          steps {
            mail(subject: 'Easy Notes Test Result', body: 'Testing done for Easy Notes Application', from: 'guptaswapnesh85@gmail.com', to: 'guptaswapnesh85@gmail.com')
          }
        }

      }
    }

  }
}