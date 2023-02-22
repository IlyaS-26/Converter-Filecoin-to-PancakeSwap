# Image with gradle on alpine, mark as build
FROM gradle:8.0-openjdk:19.0.2 AS build
# Copy in container files
COPY --chown=gradle:gradle . /home/gradle/src
# Working directory for new instruction
WORKDIR /home/gradle/src
# Run and add new slice
RUN gradle build

# Image with jdk
FROM openjdk:19.0.2-slim
# Create new directory for jar
RUN mkdir /app
# Move jar to directory
COPY --from=build /home/gradle/src/build/libs/Converter-1.0-SNAPSHOT.jar /app/app.jar
# Run application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]