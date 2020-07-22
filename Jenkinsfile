pipeline {
    agent any

    stages {
	stage('checkout SCM') {
		steps {
	           git branch: 'release/1.0.0', url: 'https://github.com/OlehZz/FootGo.git'
		}
	}
        stage('Build') {
            steps {
	//	git 'https://github.com/OlehZz/jenkins1.git'
                echo 'Copy...'
		sh label: '', script: 'copy.sh'
		echo 'Building..'
		sh sh label: '', script: 'docker build -t foorgo_build .'
	//	sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
		sh java -jar 
            }
        }
    }
}
