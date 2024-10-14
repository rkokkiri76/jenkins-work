# jenkins-work

1. https://github.com/rkokkiri76

2. jenkins installation

power on ubuntu machine 192.168.2.82



Jenkins 2.480

first create the 
cd /;mkdir /jenkins_home



# docker run -d -u root  --name jenkins -p 8080:8080  -v /jenkins_home:/var/jenkins_home -v /jenkins-init:/usr/share/jenkins/ref/init.groovy.d -e JENKINS_ADMIN_ID=jenkins -e JENKINS_ADMIN_PASSWORD=jenkins jenkins/jenkins:latest


git clone https://github.com/rkokkiri76/jenkins-work.git


docker container rm -f jenkins

docker image rm jenkins


cd /test-jenkins/jenkins-work
cd  /jenkins_home/; rm -rf .cache .java .lastStarted .bash_history *;cd -

git pull

docker build -t jenkins .
docker run -d -p 8080:8080 -v /jenkins_home:/var/jenkins_home  -e JENKINS_ADMIN_ID=jenkins -e JENKINS_ADMIN_PASSWORD=jenkins --name jenkins jenkins



docker  container logs jenkins -f

docker exec -it jenkins bash

http://192.168.2.82:8080/login?from=%2F

