FROM gradle:jdk14 AS builder
WORKDIR /home/gradle/src
COPY . .
RUN gradle test bootJar --no-daemon

FROM openjdk:14-alpine
COPY --from=builder /home/gradle/src/build/libs/FlightsService-1.0.0.jar .
EXPOSE 8080
CMD ["java","-jar", "FlightsService-1.0.0.jar", "-XX:TieredStopAtLevel=1", "-noverify"]