pipeline
{
    agent any
    tools{
    jdk "jdk"
    }

    stages {
        stage('Build') {
            steps {
                echo '>>>Conecting to git repo - Karolina >>>>>>>>>>>>>>>'
                //git 'https://github.com/karolinabargiel/Selenium7.1-Page-Object-Pattern'
                git branch: "${branch}", url: 'https://github.com/karolinabargiel/Selenium7.1-Page-Object-Pattern'
                bat 'mvn clean compile'
                //sh 'mvn clean compile' - dla linuxa
            }
        }

         stage('Test') {
            steps {
                echo '>>>Test execution - Karolina >>>>>>>>>>>>>>>'

                bat 'mvn clean test'

                //sh 'mvn clean compile' - dla linuxa

            }

        }

    }

}



