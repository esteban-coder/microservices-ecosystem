FROM openjdk:17
EXPOSE 8070
ADD ./target/users-mysql-ms-1.0.0.jar users-mysql-ms.jar
ENTRYPOINT ["java","-jar","/users-mysql-ms.jar"]