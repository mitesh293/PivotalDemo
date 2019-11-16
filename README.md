# PivotalDemo

Swagger UI-local
http://localhost:8080/swagger-ui.html


step to Deploy on PCF

>cf login -a https://api.run.pivotal.io

username: **********@gmail.com
Pass:     **********

>mvn clean install

>cd target

>cf push PivotalDemo -p PivotalDemo-0.0.1-SNAPSHOT.jar

>cf logs PivotalDemo --recent