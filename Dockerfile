FROM --platform=$BUILDPLATFORM openjdk:17.0.1
COPY build/libs/product-service-*-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "./app.jar"]