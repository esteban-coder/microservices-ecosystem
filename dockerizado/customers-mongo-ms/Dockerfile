FROM openjdk:17
#EXPOSE 8080
EXPOSE 8081
ADD ./target/customers-mongo-ms-1.0.0.jar customers-mongo-ms.jar
ENTRYPOINT ["java","-jar","/customers-mongo-ms.jar"]