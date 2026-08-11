FROM maven

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8888

CMD ["java", "-jar", "target/discovery-0.0.1-SNAPSHOT.jar"]