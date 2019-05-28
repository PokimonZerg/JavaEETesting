# Jenkins

Простейший pipeline
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

Параметры
`
pipeline {
    agent none
    parameters {
        choice(name: 'WHO', choices: ['OTUS', 'Java', 'QA'], description: 'Pick something')
    }
    stages {
        stage('My first stage') {
            steps {
                echo "Hello ${params.WHO}"
            }
        }
    }
}
`

Post actions
`
pipeline {
agent none
    parameters {
        choice(name: 'WHO', choices: ['OTUS', 'Java', 'QA'], description: 'Pick something')
    }
    stages {
        stage('My first stage') {
            steps {
                echo "Hello ${params.WHO}"
                sh "ls"
            }
        }
    }
    post { 
            always { 
                echo 'The end!'
            }
        }
}
`
