FROM openjdk:17
EXPOSE 7082
ADD ./target/consumer-customers-ms-1.0.0.jar consumer-customers-ms.jar
ENTRYPOINT ["java","-jar","/consumer-customers-ms.jar"]