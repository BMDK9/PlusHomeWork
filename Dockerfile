FROM eclipse-temurin:17-jdk-alpine
RUN apk add --no-cache tzdata
ENV TZ Asia/Seoul
ARG JAR_FILE=build/libs/practice-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} practice.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/practice.jar"]