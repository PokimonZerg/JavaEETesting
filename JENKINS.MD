# Jenkins

Почему Jenkins сейчас так популярен? Почему половина компаний использует именно его при таком богатом выборе на рынке CI систем?
Jenkins позволяет хранить полное описание сборки вашего проекта как код, вместе с вашим проектом в виде Jenkinsfile.
Если в других CI системах вам нужно конфигурировать сборку каждого проекта с помощью UI, то Jenkins позволяет задать сборку с помощью кода в вашем проекте. Более того, Jenkins поддерживает ветки. То есть сборка каждой ветки проекта может настраиваться отдельно У каждой ветки своя версия Jenkinsfile. Это значит, что если на проектом работает 10 человек, то они могут одновременно менять сборку проекта в своих ветках и не мешать друг другу. Это здорово и невероятно экономит время. Эта функциональность называется Multibranch pipeline, она появилась недавно, но уже завоевала популярность.

Jenkins развивался эволюционно и описание сборки не всегда было таким как сейчас. Раньше существовал Freestyle job, где вы должны были конфигурировать сборку в UI Jenkins. Очень похоже на другие CI системы. 
Затем появился Scripted pipeline, где сборку уже можно было определить в виде кода. Это был groovy код.
А сегодня у нас есть Declarative Pipeline Syntax, который уже использует DSL для конфигурирования сборки. Его мы и будем изучать на этом занятии как самый новый и самый приятный, хотя в реальных проектах вы можете встретить и scripted pipeline. В прочем возможности у них идентичны, просто отличается синтаксис.

В работе QA Automation Engineer вам нужно будет уметь настраивать джобы для запуска автоматизированных тестов и просто запускать скажем deploy проекта на тестовую среду.

Все что вам нужно знать для успеха: 
https://jenkins.io/doc/book/pipeline/syntax/
https://jenkins.io/doc/pipeline/steps/workflow-basic-steps/

Адрес Jenkins: 
Пароль администратора: 
Пароль пользователя: 

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
```

Параметры
```
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
```

Post actions
```
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
```
