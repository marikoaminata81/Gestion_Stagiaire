#!/bin/bash

echo "Building Eureka Server..."
cd eureka-server
mvn clean package -DskipTests
cd ..

echo "Building API Gateway..."
cd api-gateway
mvn clean package -DskipTests
cd ..

echo "Building Stagiaire Service..."
cd stagiaire-service
mvn clean package -DskipTests
cd ..

echo "Building Encadreur Service..."
cd encadreur-service
mvn clean package -DskipTests
cd ..

echo "All services built successfully!"
