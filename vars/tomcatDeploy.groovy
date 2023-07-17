def call(){
  sshagent(['tomcat-dev']) {
    sh "scp -o StrictHostKeyChecking=no target/hr-api.war  ec2-user@172.31.42.74:/opt/tomcat9/webapps/ "
      sh "ssh ec2-user@172.31.42.74 /opt/tomcat9/bin/shutdown.sh"
        sh "ssh ec2-user@172.31.42.74 /opt/tomcat9/bin/startup.sh"
  }
}
