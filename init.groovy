import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.plugin.JenkinsJobManagement
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.impl.*
import hudson.model.*
import jenkins.model.*
import hudson.plugins.groovy.*


println "Adding jdk"
Jenkins.getInstance().getJDKs().add(new JDK("jdk8", "/usr/lib/jvm/java-8-openjdk-amd64"))

println "Adding an auto installer for Maven 3.3.9"

def mavenPluginExtension = Jenkins.instance.getExtensionList(hudson.tasks.Maven.DescriptorImpl.class)[0]

def asList = (mavenPluginExtension.installations as List)
asList.add(new hudson.tasks.Maven.MavenInstallation('maven-3', null, [new hudson.tools.InstallSourceProperty([new hudson.tasks.Maven.MavenInstaller("3.3.9")])]))

mavenPluginExtension.installations = asList

mavenPluginExtension.save()

println "OK - Maven auto-installer (from Apache) added for 3.3.9"
