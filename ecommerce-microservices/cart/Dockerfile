FROM maven

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8888

CMD ["java", "-jar", "target/cart-0.0.1-SNAPSHOT.jar"]