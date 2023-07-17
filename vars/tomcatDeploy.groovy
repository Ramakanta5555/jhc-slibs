def call(user,ip){
  sshagent(['tomcat-dev']) {
    sh "scp -o StrictHostKeyChecking=no target/hr-api.war  ${user}@${ip}:/opt/tomcat9/webapps/ "
      sh "ssh ec2-${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
        sh "ssh ec2-${user}@${ip} /opt/tomcat9/bin/startup.sh"
  }
}
