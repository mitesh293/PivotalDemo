# PivotalDemo


cf login -a https://api.run.pivotal.io

mvn clean install

cf push PivotalDemo -p PivotalDemo-0.0.1-SNAPSHOT.jar