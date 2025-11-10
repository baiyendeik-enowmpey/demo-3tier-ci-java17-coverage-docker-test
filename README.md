# Demo 3-Tier CI (Java 17 + Coverage + Docker Smoke Test)

![Build Status](https://github.com/baiyendeik-enowmpey/demo-3tier-ci-java17-coverage-docker-test/actions/workflows/ci.yml/badge.svg)
![Coverage](https://img.shields.io/badge/coverage-unknown-lightgrey.svg)

Dieses Projekt demonstriert einen vollständigen CI/CD-Ablauf mit Smoke-Test des Docker-Containers.

## CI/CD Schritte
1. **Checkout Code** – Repository wird ausgecheckt
2. **Setup Java 17** – Laufzeitumgebung wird eingerichtet
3. **Maven Build & Tests** – Code wird kompiliert und Unit-Tests ausgeführt
4. **JaCoCo Coverage Report** – Testabdeckung wird generiert
5. **Docker Build** – Docker-Image wird erstellt
6. **Smoke-Test** – Container wird gestartet und `/actuator/health` geprüft

## Voraussetzungen
In der `pom.xml` muss folgendes Dependency vorhanden sein:
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Damit ist der Health Endpoint unter [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health) erreichbar.
