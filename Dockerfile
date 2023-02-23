# Image with gradle on alpine, mark as build
FROM gradle:7.6-openjdk:15.0.2-alpine AS build
# Copy in contaier files
COPY .  /home/
# Working directory for new instruction
WORKDIR /home/
# Run and add new slice
RUN gradle build

# Image with jre
FROM openjdk:15.0.2-slim

# Create new directory for jar
RUN mkdir /app
# Move jar to directory
COPY --from=build /home/build/libs/Test-0.0.1-SNAPSHOT.jar /app/Test-0.0.1-SNAPSHOT.jar
# Run application
ENTRYPOINT ["java","-jar","/app/app.jar"]