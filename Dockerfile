# Use a base image with Maven and Java pre-installed
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project definition (pom.xml) to the container
COPY pom.xml .

# Copy the entire project source code to the container
COPY src ./src

# Build the application with 'mvn clean install'
RUN mvn clean install

FROM openjdk:11
EXPOSE 8080
ADD target/online-exam-back.jar online-exam-back.jar
ENTRYPOINT ["java","-jar","/online-exam-back.jar"]