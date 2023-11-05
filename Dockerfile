FROM openjdk:17-oracle
COPY target/BookStoreIngress-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "BookStoreIngress-0.0.1-SNAPSHOT.jar"]