# Jenkins

```
pipeline {
    agent none
    stages {
        stage('My first stage') {
            steps {
                echo "Hello world!"
            }
        }
    }
}
