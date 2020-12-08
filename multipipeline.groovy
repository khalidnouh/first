     
pipeline {
   agent any
    environment {
    PATH = "C://Program Files//Java//jdk1.8.0_241//bin"+ ";c:\\Windows\\System32"+";C://apache-maven-3.6.3-bin//apache-maven-3.6.3//bin"
   
  }
   stages {
    stage('Checkouttt') {
      steps {
        script {

           // The below will clone your repo and will be checked out to master branch by default.
           git credentialsId: 'khalid_m_n2000@yahoo.com', url: 'https://github.com/khalidnouh/first.git'
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
          }
       }
    }
    
    stage('building') {
      steps {
        script {
            bat" mvn  -f C://Windows//System32//config//systemprofile//AppData//Local//Jenkins//.jenkins//workspace//firstpipeline//first//first clean install"

          }
      }
    }
     stage('deploy') {
      steps {
        script {
                bat" mvn  -f C://Windows//System32//config//systemprofile//AppData//Local//Jenkins//.jenkins//workspace//firstpipeline//first//first spring-boot:run"

          }
      }
    }
  }  
}
