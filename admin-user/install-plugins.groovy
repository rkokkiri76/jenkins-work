import jenkins.model.*
import hudson.PluginManager
import hudson.util.VersionNumber

def plugins = new File("/var/jenkins_home/plugins.txt").readLines()
def pluginManager = Jenkins.getInstance().getPluginManager()

plugins.each { plugin ->
    try {
        pluginManager.install(plugin.trim())
    } catch (Exception e) {
        println("Failed to install plugin: ${plugin} - ${e.message}")
    }
}
