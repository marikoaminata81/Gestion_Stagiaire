#!/bin/bash

# Démarrer Eureka Server en arrière-plan
java -jar eureka-server.jar &

# Attendre que Eureka soit prêt
sleep 30

# Démarrer API Gateway en arrière-plan
java -jar api-gateway.jar &

# Démarrer les services métier en arrière-plan
java -jar stagiaire-service.jar &
java -jar encadreur-service.jar &

# Garder le conteneur en vie
wait
