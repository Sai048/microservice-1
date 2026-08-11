FROM maven

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8989

CMD ["java", "-jar", "target/products-0.0.1-SNAPSHOT.jar"]