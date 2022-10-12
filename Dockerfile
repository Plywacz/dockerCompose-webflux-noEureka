FROM openjdk:19

# Refer to Maven build -> finalName
ARG JAR_FILE=client-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY target/${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","app.jar"]
