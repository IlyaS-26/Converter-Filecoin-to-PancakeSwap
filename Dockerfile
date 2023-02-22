# Image with gradle on alpine, mark as build
FROM gradle:7.5.1-jdk11-alpine AS build
# Copy in container files
COPY --chown=gradle:gradle . /home/gradle/src
# Working directory for new instruction
WORKDIR /home/gradle/src
# Run and add new slice
RUN gradle build

# Image with jdk
FROM openjdk:11-jre-slim
# Need to open 9001 port
EXPOSE 9001
# Create new directory for jar
RUN mkdir /app
# Move jar to directory
COPY --from=build /home/gradle/src/build/libs/Converter-1.0-SNAPSHOT.jar /app/app.jar
# Run application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]