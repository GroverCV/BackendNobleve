# Etapa de construcción
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app  # Establece el directorio de trabajo dentro del contenedor
COPY . .  # Copia el contenido del proyecto al directorio de trabajo
RUN mvn clean package -DskipTests  # Compila el proyecto, generando el .jar

# Etapa de producción
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app  # Asegúrate de estar en el directorio correcto
COPY --from=build /app/target/apirest-0.0.1-SNAPSHOT.jar demo.jar  # Copia el .jar desde la etapa anterior
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "demo.jar" ]
