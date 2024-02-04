FROM openjdk:11
EXPOSE 9100
ADD ./target/oauth-server-1.0.0.jar oauth-server.jar
ENTRYPOINT ["java","-jar","/oauth-server.jar"]