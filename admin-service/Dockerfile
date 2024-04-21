FROM openjdk:11

EXPOSE 9090

ADD ./target/admin-service-0.0.1-SNAPSHOT.jar /admin-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar", "/admin-service-0.0.1-SNAPSHOT.jar"]