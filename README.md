# Spring-Boot Camel QuickStart

This example demonstrates:  
1. how to use `camel-restdsl-swagger-plugin` to generate REST DSL and DTO from API Document
2. how to implement REST API using Apache Camel with Spring Boot

More detail could be found in Red Hat Workshop `dayinthelife` at [here](https://github.com/RedHatWorkshops/dayinthelife-integration/blob/master/docs/labs/developer-track/lab03/walkthrough.adoc).

The quickstart uses Spring Boot to configure `location API` that includes 2 Camel route, which select records from location table in PostgreSQL.

### Generate REST DSL and DTO

    mvn clean camel-restdsl-swagger:generate-xml-with-dto

> The generated REST DSL(camel-rest.xml) has an invalid `restConfiguration` element. You can delete it.

### Building

The example can be built with

    mvn install

### Running the example in OpenShift

It is assumed that:
- OpenShift platform is already running, if not you can find details how to [Install OpenShift at your site](https://docs.openshift.com/container-platform/3.3/install_config/index.html).
- Your system is configured for Fabric8 Maven Workflow, if not you can find a [Get Started Guide](https://access.redhat.com/documentation/en/red-hat-jboss-middleware-for-openshift/3/single/red-hat-jboss-fuse-integration-services-20-for-openshift/)

The example can be built and run on OpenShift using a single goal:

    mvn fabric8:deploy

When the example runs in OpenShift, you can use the OpenShift client tool to inspect the status

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

You can also use the OpenShift [web console](https://docs.openshift.com/container-platform/3.3/getting_started/developers_console.html#developers-console-video) to manage the
running pods, and view logs and much more.

### Running via an S2I Application Template

Application templates allow you deploy applications to OpenShift by filling out a form in the OpenShift console that allows you to adjust deployment parameters.  This template uses an S2I source build so that it handle building and deploying the application for you.

First, import the Fuse image streams:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/GA/fis-image-streams.json

Then create the quickstart template:

    oc create -f https://raw.githubusercontent.com/jboss-fuse/application-templates/GA/quickstarts/spring-boot-camel-template.json

Now when you use "Add to Project" button in the OpenShift console, you should see a template for this quickstart. 

