node {
  stage('one') {
    echo "stage - 1"
    echo env.NODE_NAME
  }
    stage('two') {
      echo "stage -2 "
      echo "build number ${env.BUILD_NUMBER}"
      
  }
    stage('three') {
      echo "stage - 3"
        echo sh(script: 'env|sort', returnStdout: true)
  }
}
