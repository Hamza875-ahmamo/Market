# Market Microservices Architecture

Ce projet est une architecture microservices basée sur **Quarkus** et déployée à l'aide de **Docker Compose**.

## 🏗️ Architecture des Services

Le système est composé des services et infrastructures suivants, gérés ensemble via `docker-compose.yml` :

1. **Customer Service** (Port `8081`) : Microservice responsable de la gestion des clients. Chaque ressource est persistée dans sa propre base de données PostgreSQL. 
2. **Billing Service** (Port `8082`) : Microservice responsable de la facturation (invoices) et qui communique avec le Customer Service. Utilise aussi une base de données PostgreSQL dédiée.
3. **Gateway Service** (Port `8888`) : API Gateway servant de point d'entrée unique et de routeur pour les clients de l'API. Utilise la découverte de services pour trouver les instances en cours d'exécution.
4. **Consul (HashiCorp)** (Port `8500`) : Service de découverte (Service Discovery) vers lequel chaque service s'enregistre, permettant au Gateway de les localiser dynamiquement.
5. **PostgreSQL** (Ports `5433` et `5434`) : Bases de données dédiées (`customerdb` et `billingdb`) pour les microservices.

## 🛠️ Stack Technique

- **Framework :** Quarkus (Java 17)
- **Persistance des données :** PostgreSQL (piloté par Hibernate ORM with Panache)
- **Découverte de Service :** Consul (via intégration SmallRye Stork)
- **Mappeur d'objets DTO :** MapStruct conjointement avec Lombok
- **Conteneurisation :** Docker & Docker Compose
- **Client REST :** Quarkus REST Client (pour les communications inter-services)

## 🚀 Démarrer le Projet

Pour lancer l'ensemble des services (bases de données, Consul et microservices) d'un seul coup, exécutez la commande suivante à la racine du projet :

```bash
docker-compose up --build -d
```

> **Note :** Le flag `--build` s'assurera que les conteneurs Docker Quarkus (en mode jvm) sont construits ou mis à jour grâce au processus de construction intégré de la JVM. Docker Compose se charge de coordonner tout l'environnement réseau (`market-network`).

### 🌐 Accéder aux Services :

- **Consul UI :** [http://localhost:8500](http://localhost:8500)
- **Gateway Service (Point d'entrée) :** [http://localhost:8888](http://localhost:8888)
- **Customer Service (Accès Direct) :** [http://localhost:8081](http://localhost:8081)
- **Billing Service (Accès Direct) :** [http://localhost:8082](http://localhost:8082)

Il est conseillé de faire toutes vos requêtes (ex. via Postman) à travers le port **8888** du Gateway Service.

## 📄 Structure du Dépôt

- `📁 customer-service` : Code source du service client.
- `📁 billing-service` : Code source du service de facturation.
- `📁 gateway-service` : Code source de la passerelle API.
- `📄 docker-compose.yml` : Configuration liant tous les composants de l'infrastructure Docker.
