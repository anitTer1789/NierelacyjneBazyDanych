FROM maven:3.6.2-jdk-11-slim

# copy the project files
COPY ./pom.xml ./pom.xml
COPY ./src ./src

#RUN mvn dependency:go-offline -B
RUN mvn clean install -Dmaven.test.skip=true

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "target/AustralianWeather-0.0.1-SNAPSHOT.jar"]
