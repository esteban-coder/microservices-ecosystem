FROM openjdk:17
VOLUME /tmp
EXPOSE 8889
ADD ./target/config-server-1.0.0.jar config-server.jar
ENTRYPOINT ["java","-jar","/config-server.jar"]