# Imagen base con Maven y JDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Establecer directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto
COPY Tarea2/ ./Tarea2/

# Compilar el proyecto y empaquetar con dependencias
RUN mvn -f Tarea2/pom.xml clean package -DskipTests

# Segunda etapa: Imagen ligera con solo JDK para ejecución
FROM eclipse-temurin:17-jdk

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR compilado desde la etapa anterior
COPY --from=build /app/Tarea2/App2/target/App2-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Comando de ejecución
CMD ["java", "-jar", "app.jar"]
