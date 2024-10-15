# jenkins-work

1. https://github.com/rkokkiri76

2. jenkins installation

power on ubuntu machine 192.168.2.82

# mount for jenkins data on local
cd /;mkdir /jenkins_home


mkdir /test-jenkins
useradd jenkins
usermod -G docker jenkins


root@ubuntu:/jenkins_home# id raj
uid=1000(raj) gid=1000(raj) groups=1000(raj),4(adm),24(cdrom),27(sudo),30(dip),46(plugdev),100(users),114(lpadmin)
root@ubuntu:/jenkins_home# id jenkins
uid=1001(jenkins) gid=1001(jenkins) groups=1001(jenkins),984(docker)
root@ubuntu:/jenkins_home# 

cd test-jenkins
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

################################################################################

pipelines are two types
1. declarative pipeline  -test-multibranch  develop

2. scripted pipeline  -  test-multibranch   master

Jenkinsfile  style decides which pipeline is


multibranch pipeline, this is used to scan the all branches in the repo whose have Jenkinsfile then that will create and build first time. we can do auto trigger as using webhook.

multibranch with defaults , this pipeline take global Jenkinsfile so if the repo one of the branch dont have Jenkinsfile also will create during the scan.


# ===============================================================================