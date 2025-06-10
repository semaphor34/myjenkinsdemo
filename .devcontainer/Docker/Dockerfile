FROM jenkins/jenkins:lts-21

RUN jenkins-plugin-cli --plugins \
    git:latest \
    workflow-aggregator:latest \
    blueocean:latest \
    credentials:latest \
    pipeline-github-lib:latest \
    pipeline-utility-steps:latest \
    docker-workflow:latest \
    maven-plugin:latest \
    junit:latest \
    email-ext:latest \
    matrix-auth:latest \
    ansicolor:latest \
    job-dsl:latest \
    warnings-ng:latest \
    cloudbees-folder:latest \
    antisamy-markup-formatter:latest \
    build-timeout:latest \
    credentials-binding:latest \
    timestamper:latest \
    ws-cleanup:latest \
    ant:latest \
    authorize-project:latest \
    github-branch-source:latest \
    pipeline-stage-view:latest \
    ssh-agent:latest \
    pam-auth:latest \
    ldap:latest \
    mailer:latest \
    dark-theme:latest \
    configuration-as-code:latest \
    simple-theme-plugin:latest \
    gitlab-plugin:latest \
    docker-plugin:latest

COPY casc.yaml /var/jenkins_conf/casc.yaml
COPY jobdsl/ /var/jobdsl/