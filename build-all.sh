#!/bin/bash

echo "===================================="
echo "Construindo todos os microsserviços"
echo "===================================="

echo "Building service-discovery..."
mvn -f service-discovery-pom.xml clean package -DskipTests

echo "Building api-gateway..."
mvn -f gateway-pom.xml clean package -DskipTests

echo "Building auth-service..."
mvn -f auth-pom.xml clean package -DskipTests

echo "Building pedido-service..."
mvn -f pedido-pom.xml clean package -DskipTests

echo "Building pagamento-service..."
mvn -f pagamento-pom.xml clean package -DskipTests

echo "===================================="
echo "Build concluído com sucesso!"
echo "===================================="
