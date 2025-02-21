# Usar una imagen oficial de Maven con JDK 17 para la compilación
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos del proyecto
COPY RomperCiclos-Tarea/ . 

# Compilar el proyecto y generar el JAR con dependencias
RUN mvn clean package -DskipTests -pl InicioMain -am

# Usar una imagen más ligera con JDK para ejecutar la aplicación
FROM eclipse-temurin:17-jdk

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR generado desde la etapa anterior
COPY --from=build /app/InicioMain/target/InicioMain-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080


# Ejecutar la aplicación
CMD ["java", "-jar", "/app/app.jar"]
