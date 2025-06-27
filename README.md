# Gestion des Stagiaires

**Nom:** [Votre Nom]  
**Prénom:** [Votre Prénom]

## Description du Projet

Ce projet permet de gérer les stagiaires et leurs encadreurs avec une architecture microservices utilisant Spring Boot.

## Architecture du Projet

Le projet contient 5 services :
- **Eureka Server** (Port 8762) - Pour découvrir les services
- **API Gateway** (Port 9090) - Point d'entrée principal
- **Stagiaire Service** (Port 9091) - Gestion des stagiaires
- **Encadreur Service** (Port 9092) - Gestion des encadreurs
- **MySQL Database** (Port 3308) - Base de données

## Prérequis pour Exécuter le Projet

Avant de commencer, vous devez installer :

1. **Docker Desktop** 
   - Télécharger depuis : https://www.docker.com/products/docker-desktop
   - Installer et démarrer Docker Desktop

2. **Java 17** (pour le développement local)
   - Télécharger depuis : https://adoptium.net/
   - Vérifier l'installation : \`java -version\`

3. **Maven** (pour compiler le projet)
   - Télécharger depuis : https://maven.apache.org/download.cgi
   - Vérifier l'installation : \`mvn -version\`

## Procédure d'Exécution Complète

### Étape 1 : Télécharger le Projet
\`\`\`bash
# Cloner ou télécharger le projet
# Extraire dans un dossier (ex: C:\\gestion-stagiaires)
\`\`\`

### Étape 2 : Ouvrir le Terminal
- **Windows** : Ouvrir "Invite de commandes" ou "PowerShell"
- **Mac/Linux** : Ouvrir "Terminal"

### Étape 3 : Naviguer vers le Projet
\`\`\`bash
cd C:\\gestion-stagiaires
# ou le chemin où vous avez extrait le projet
\`\`\`

### Étape 4 : Compiler Chaque Service

**Compiler Eureka Server :**
\`\`\`bash
cd eureka-server
mvn clean package -DskipTests
cd ..
\`\`\`

**Compiler API Gateway :**
\`\`\`bash
cd api-gateway
mvn clean package -DskipTests
cd ..
\`\`\`

**Compiler Stagiaire Service :**
\`\`\`bash
cd stagiaire-service
mvn clean package -DskipTests
cd ..
\`\`\`

**Compiler Encadreur Service :**
\`\`\`bash
cd encadreur-service
mvn clean package -DskipTests
cd ..
\`\`\`

### Étape 5 : Démarrer Tous les Services
\`\`\`bash
docker-compose up -d
\`\`\`

### Étape 6 : Vérifier que Tout Fonctionne

Attendre 2-3 minutes puis ouvrir ces liens dans votre navigateur :

1. **Eureka Server** : http://localhost:8762
   - Vous devriez voir les services enregistrés

2. **Swagger Stagiaire Service** : http://localhost:9091/swagger-ui.html
   - Interface pour tester les APIs des stagiaires

3. **Swagger Encadreur Service** : http://localhost:9092/swagger-ui.html
   - Interface pour tester les APIs des encadreurs

4. **Actuator Stagiaire** : http://localhost:9091/actuator/health
   - Doit afficher : \`{"status":"UP"}\`

5. **Actuator Encadreur** : http://localhost:9092/actuator/health
   - Doit afficher : \`{"status":"UP"}\`

## Comment Tester les APIs

### Créer un Encadreur
\`\`\`bash
curl -X POST http://localhost:9090/api/encadreurs \\
  -H "Content-Type: application/json" \\
  -d "{
    \\"nom\\": \\"Dupont\\",
    \\"prenom\\": \\"Jean\\",
    \\"email\\": \\"jean.dupont@example.com\\",
    \\"telephone\\": \\"0123456789\\"
  }"
\`\`\`

### Créer un Stagiaire
\`\`\`bash
curl -X POST http://localhost:9090/api/stagiaires \\
  -H "Content-Type: application/json" \\
  -d "{
    \\"nom\\": \\"Martin\\",
    \\"prenom\\": \\"Pierre\\",
    \\"email\\": \\"pierre.martin@example.com\\",
    \\"dateDebut\\": \\"2024-01-15\\",
    \\"dateFin\\": \\"2024-06-15\\",
    \\"encadreurId\\": 1
  }"
\`\`\`

### Récupérer Tous les Stagiaires
\`\`\`bash
curl http://localhost:9090/api/stagiaires
\`\`\`

### Récupérer Tous les Encadreurs
\`\`\`bash
curl http://localhost:9090/api/encadreurs
\`\`\`

## Arrêter le Projet

Pour arrêter tous les services :
\`\`\`bash
docker-compose down
\`\`\`

Pour supprimer aussi les données :
\`\`\`bash
docker-compose down -v
\`\`\`

## Structure des Dossiers

\`\`\`
gestion-stagiaires/
├── eureka-server/          # Service de découverte
├── api-gateway/            # Passerelle API
├── stagiaire-service/      # Service des stagiaires
├── encadreur-service/      # Service des encadreurs
├── docker-compose.yml      # Configuration Docker
└── README.md              # Ce fichier
\`\`\`

## Endpoints Disponibles

### Stagiaires (/api/stagiaires)
- \`GET /api/stagiaires\` - Liste tous les stagiaires
- \`GET /api/stagiaires/{id}\` - Récupère un stagiaire
- \`POST /api/stagiaires\` - Crée un stagiaire
- \`PUT /api/stagiaires/{id}\` - Modifie un stagiaire
- \`DELETE /api/stagiaires/{id}\` - Supprime un stagiaire

### Encadreurs (/api/encadreurs)
- \`GET /api/encadreurs\` - Liste tous les encadreurs
- \`GET /api/encadreurs/{id}\` - Récupère un encadreur
- \`POST /api/encadreurs\` - Crée un encadreur
- \`PUT /api/encadreurs/{id}\` - Modifie un encadreur
- \`DELETE /api/encadreurs/{id}\` - Supprime un encadreur

## Résolution des Problèmes

### Si Docker ne démarre pas :
1. Vérifier que Docker Desktop est lancé
2. Redémarrer Docker Desktop
3. Essayer : \`docker-compose down\` puis \`docker-compose up -d\`

### Si la compilation échoue :
1. Vérifier que Java 17 est installé : \`java -version\`
2. Vérifier que Maven est installé : \`mvn -version\`
3. Supprimer le dossier \`target\` et recompiler

### Si les services ne se connectent pas :
1. Attendre 3-5 minutes (temps de démarrage)
2. Vérifier les logs : \`docker-compose logs\`
3. Redémarrer : \`docker-compose restart\`

## Technologies Utilisées

- **Spring Boot 3.1.0** - Framework principal
- **Spring Cloud 2022.0.3** - Microservices
- **Spring Data JPA** - Accès aux données
- **MySQL 8.0** - Base de données
- **Docker** - Conteneurisation
- **Swagger** - Documentation API
- **Actuator** - Monitoring
