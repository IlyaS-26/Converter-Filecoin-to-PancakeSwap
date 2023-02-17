# Image with gradle on alpine, mark as build
FROM gradle:8.0-openjdk:19.0.2 AS build
# Copy in container files
COPY .  /home/
# Working directory for new instruction
WORKDIR /home/
# Run and add new slice
RUN gradle build

# Image with jdk
FROM openjdk:19.0.2-slim
# Create new directory for jar
RUN mkdir /app
# Move jar to directory
COPY --from=build /home/build/libs/idea_projects-0.0.1-SNAPSHOT.jar /app/idea_projects-0.0.1-SNAPSHOT.jar
# Run application
ENTRYPOINT ["java", "-jar", "/app/idea_projects.jar"]