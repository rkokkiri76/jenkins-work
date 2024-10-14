// import jenkins.model.*
// import hudson.security.*
// import hudson.model.User
// import hudson.security.HudsonPrivateSecurityRealm

// // Get the Jenkins instance
// def jenkinsInstance = Jenkins.getInstance()

// // Get the environment variables
// def adminUserId = System.getenv('JENKINS_ADMIN_ID') ?: 'admin'
// def adminPassword = System.getenv('JENKINS_ADMIN_PASSWORD') ?: 'admin'

// // Set up security realm
// def hudsonRealm = new HudsonPrivateSecurityRealm(false)
// jenkinsInstance.setSecurityRealm(hudsonRealm)

// // Create the admin user if it doesn't already exist
// def user = User.get(adminUserId, false)
// if (user == null) {
//     user = User.get(adminUserId, true)
//     user.setFullName("Admin User")
//     hudsonRealm.createAccount(adminUserId, adminPassword)
//     println "Created admin user: ${adminUserId}"
// } else {
//     println "User ${adminUserId} already exists."
// }

// // Set the authorization strategy to allow full control for the created user
// jenkinsInstance.setAuthorizationStrategy(new FullControlOnceLoggedInAuthorizationStrategy())

// // Save the Jenkins instance
// jenkinsInstance.save()


import jenkins.model.*
import hudson.security.*

// Get the Jenkins instance
def jenkinsInstance = Jenkins.getInstance()

// Get the environment variables
def adminUserId = System.getenv('JENKINS_ADMIN_ID') ?: 'admin'
def adminPassword = System.getenv('JENKINS_ADMIN_PASSWORD') ?: 'admin'

// Create the admin user if it doesn't already exist
def user = hudson.model.User.get(adminUserId, false)
if (user == null) {
    user = hudson.model.User.get(adminUserId, true)
    user.setFullName("Admin User")
    user.setPassword(adminPassword)
    user.save()

    // Set up security realm and authorization strategy
    def strategy = new GlobalMatrixAuthorizationStrategy()
    strategy.add(Jenkins.ADMINISTER, adminUserId)
    jenkinsInstance.setAuthorizationStrategy(strategy)
    jenkinsInstance.save()

    println "Created admin user: ${adminUserId}"
} else {
    println "User ${adminUserId} already exists."
}
