FROM openjdk:8

# Expect AWS CLI credentials to be passed in as build arguments
#ARG AWS_ACCESS_KEY_ID
#ARG AWS_SECRET_ACCESS_KEY

ADD target/PivotalDemo-0.0.1-SNAPSHOT.jar PivotalDemo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","PivotalDemo-0.0.1-SNAPSHOT.jar"]