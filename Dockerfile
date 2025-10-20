# Étape 1 : Choisir l'image de base Tomcat avec JDK 11
# Correction : Le format officiel est 'tomcat:9.0' (avec un point)
FROM tomcat:9.0-jdk11-openjdk-slim

# Étape 2 : Définir le répertoire de travail dans Tomcat
# Correction : Il faut des barres obliques pour les chemins dans Docker (environnement Linux)
WORKDIR /usr/local/tomcat/webapps

# Étape 3 : Copier votre fichier WAR dans le répertoire 'webapps' de Tomcat
# Assurez-vous que le chemin et le nom sont corrects
COPY target/TP_Global_Devops-1.0.0-SNAPSHOT.war .

# Étape 4 : Exposer le port par défaut de Tomcat
EXPOSE 8080

# L'image de base Tomcat est déjà configurée pour démarrer l'application.
