<<<<<<< HEAD
# 🚀 PROFU-2

**PROFU-2** es un proyecto desarrollado en Java con Maven, preparado para ejecutarse dentro de un contenedor Docker. Este repositorio incluye la configuración necesaria para compilar y ejecutar la aplicación de manera eficiente.

## 📌 Requisitos

Antes de comenzar, asegúrate de tener instalado:

- [Docker](https://www.docker.com/)
- [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)

## 🛠️ Construcción y ejecución con Docker

Para construir y ejecutar la aplicación dentro de un contenedor Docker, sigue estos pasos:

### 1️⃣ Construir la imagen Docker:

```sh
docker build -t ejercicio1 .
```

### 2️⃣ Ejecutar el contenedor:

```sh
docker run -p 8080:8080 ejercicio1
```

La aplicación estará disponible en `http://localhost:8080`.

## 📁 Estructura del Proyecto

```
PROFU-2/
│── RomperCiclos-Tarea/
│   ├── App1DTO/
│   ├── App1Entities/
│   ├── App1UseCases/
│   ├── App1ViewCases/
│   ├── Controllers/
│   ├── InicioMain/
│   │   ├── src/
│   │   ├── target/
│   │   │   ├── InicioMain-1.0-SNAPSHOT-jar-with-dependencies.jar
│   │   │   ├── InicioMain-1.0-SNAPSHOT.jar
│── .gitignore
│── pom.xml
│── README.md
```

## 🎯 Notas

- Se utiliza el archivo JAR con dependencias (`InicioMain-1.0-SNAPSHOT-jar-with-dependencies.jar`) para evitar problemas de librerías faltantes.
- Si necesitas cambiar el puerto de ejecución, modifícalo en el `Dockerfile` o usa `-p <PUERTO_LOCAL>:8080` en el `docker run`.

📌 **¡Listo para desplegar y probar!** 🚀

=======
docker build -t tarea2-app . 
docker run --rm -it tarea2-app
>>>>>>> tarea2
