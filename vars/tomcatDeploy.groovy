def call(ip,warName,credId){
sshagent(["${credId}"]) {
   // Copy war file to tomcat
   sh "scp -o StrictHostKeyChecking=no target/${warName}.war ec2-user@${ip}:/opt/tomcat9/webapps"
   sh "ssh ec2-user@${ip} /opt/tomcat9/bin/shutdown.sh"
   sh "ssh ec2-user@${ip} /opt/tomcat9/bin/startup.sh"
}
}
