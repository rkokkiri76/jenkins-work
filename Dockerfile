FROM jenkins/jenkins:latest


# ARG user=jenkins
# ARG group=jenkins

# ARG uid=1000
# ARG gid=1000



# USER jenkins

USER root




COPY plugins.txt /usr/share/jenkins/ref/


# Adding default Jenkins Jobs
# COPY jobs/1-github-seed-job.xml /usr/share/jenkins/ref/jobs/1-github-seed-job/config.xml
# COPY jobs/2-job-dsl-seed-job.xml /usr/share/jenkins/ref/jobs/2-job-dsl-seed-job/config.xml
# COPY jobs/3-conference-app-seed-job.xml /usr/share/jenkins/ref/jobs/3-conference-app-seed-job/config.xml

############################################
# Configure Jenkins
############################################
# Jenkins settings
# COPY config/config.xml /usr/share/jenkins/ref/config.xml

# Jenkins Settings, i.e. Maven, Groovy, ...
# COPY config/hudson.tasks.Maven.xml /usr/share/jenkins/ref/hudson.tasks.Maven.xml
# COPY config/maven-global-settings-files.xml /usr/share/jenkins/ref/maven-global-settings-files.xml
COPY config/*  /usr/share/jenkins/ref/
COPY admin-user/create-admin-user.groovy /usr/share/jenkins/ref/init.groovy.d/
# COPY admin-user/install-plugins.groovy    /usr/share/jenkins/ref/init.groovy.d/

# SSH Keys & Credentials
# COPY config/credentials.xml /usr/share/jenkins/ref/credentials.xml
# COPY config/ssh-keys/cd-demo /usr/share/jenkins/ref/.ssh/id_rsa
# COPY config/ssh-keys/cd-demo.pub /usr/share/jenkins/ref/.ssh/id_rsa.pub

# RUN chown -R jenkins:jenkins /var/jenkins_home


# USER jenkins

# RUN /usr/local/bin/plugins.sh /var/jenkins_home/plugins.txt
RUN jenkins-plugin-cli --plugins -f /usr/share/jenkins/ref/plugins.txt