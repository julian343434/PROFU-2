# Usar OpenJDK como base
FROM openjdk:17-jdk-slim

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY Tarea2/App2/target/App2-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Exponer el puerto de la aplicación (ajústalo si es diferente)
EXPOSE 8080

# Comando para ejecutar el JAR
CMD ["java", "-jar", "app.jar"]
