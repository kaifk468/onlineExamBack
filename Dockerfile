FROM openjdk:11
EXPOSE 8080
ADD target/online-exam-back.jar online-exam-back.jar
ENTRYPOINT ["java","-jar","/online-exam-back.jar"]