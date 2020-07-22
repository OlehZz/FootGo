pipeline {
    agent any

    stages {
	stage('checkout SCM') {
		steps {
	           git branch: 'release/1.0.0', url: 'https://github.com/WiseHands/FootGo.git'
		}
	}
        stage('Build') {
            steps {
		git 'https://github.com/OlehZz/jenkins1.git'
#			{ 
#	  		filename 'Dockerfile'
#         			additionalBuildArgs '-t footgo_build' 
#				}
			}	
                echo 'Copy...'
		sh label: '', script: '/home/vagrant/copy.sh'
		echo 'Building..'
		sh "mvn -Dmaven.test.failure.ignore=true clean package"
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
