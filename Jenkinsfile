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
            echo 'Tesing Easy Notes'
          }
        }

      }
    }

  }
}