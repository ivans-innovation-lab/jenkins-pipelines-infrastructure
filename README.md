
# Jenkins Pipelines Infrastructure

This is meant to be a minimal example showing how to set up Jenkins 2.x with the [Pipeline Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Pipeline+Plugin) to support the following scenario:

 * all jobs are under version control and described via [Job-DSL](https://github.com/jenkinsci/job-dsl-plugin/wiki), see the [jenkins-pipelines-jobs](https://github.com/ivans-innovation-lab/jenkins-pipelines-jobs) repo
 * there is a [seed-job](https://github.com/ivans-innovation-lab/jenkins-pipes-infra/blob/master/seedJob.xml) which runs periodically to ensure the aforementioned jobs exist in Jenkins
 * each project to be built by these jobs defines its own pipeline via [Pipeline-DSL](https://jenkins.io/doc/book/pipeline/syntax/) in a `Jenkinsfile`, see the  [my-company-monolithic-web](https://github.com/ivans-innovation-lab/my-company-monolithic-web) example


## Run It


```
$ docker-compose up --build
```

Once Jenkins is started you should see at least the seed-job on [http://localhost:9090](http://localhost:9090).

If it has not run yet, simply trigger it and see how the actual jobs get created.

Artifactory is available on http://localhost:9091
