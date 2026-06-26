FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY target/*.jar app.jar
# Asegúrate de poner el puerto que usa tu ms-carrito en su application.yml
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]