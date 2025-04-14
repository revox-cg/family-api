# Utilisez l'image JDK 21
FROM openjdk:21-ea-17-jdk-slim-buster

# Définir le répertoire de t4ravail dans le conteneur
WORKDIR /app

# Copier l'intégralité du projet dans le conteneur
COPY . /app

# Donner des permissions d'exécution au wrapper Gradle
RUN chmod +x ./mvnw

# Construire le projet en utilisant Gradle
RUN ./mvnw clean package -DskipTests

# Exposer le port sur lequel l'application fonctionne
EXPOSE 8080

CMD ["java", "--enable-preview", "-jar", "target/family-0.0.1-SNAPSHOT.jar"]