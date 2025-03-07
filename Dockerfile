# 1. Usar OpenJDK 21
FROM eclipse-temurin:21-jdk

# 2. Directorio de trabajo
WORKDIR /app

# 3. Copiar el JAR desde la carpeta `target`
COPY target/crud-0.0.1-SNAPSHOT.jar app.jar

# 4. Exponer el puerto 8080
EXPOSE 8080

# 5. Ejecutar la API
ENTRYPOINT ["java", "-jar", "app.jar"]
