# biblioP3REST

Adatation REST du projet [biblioP3SOAP](https://github.com/briceroro/biblioP3SOAP-en-mode-legacy-)

## Technologies utilisés:

### WebService 
* OpenJDk 11
* Maven 3.6.0
* Spring Boot 2.2.2
  * data JPA
  * Spring Web
  * Lombok
  * freemarker
* MYSQL 5.7
* SWAGGER UI 2.8.0

### WebApp
* OpenJDk 11
* Maven 3.6.0
* Spring Boot 2.2.2
  * Security
  * Thymleaf
  * Spring web
  * Lombok
* Spring cloud 2.2.2
  * openFeign


## Configuration rapide

### webService et webApp:
#### gestion Tomcat

Dans le fichier application.properties
* server.port:
Definir un port différent d'un port deja utilisé( ex: Glassfish)
```java
# tomcat
server.port= le port choisi pour votre App
```
### webService
#### gestion BDD

Dans le fichier application.properties
* spring.datasource.url:
L'adresse de votre BDD.*(rajouter si probleme de timezone aprés votre BDD: useSSL=false&amp;serverTimezone=UTC)*  
* spring.datasource.username:
Votre user.
* connection.password:
Le password de votre user

```java
        spring.datasource.url=jdbc:mysql://localhost:3306/biblio
        spring.datasource.username=*************
        spring.datasource.password=*************
```

## Déployement des Applications 

Une fois les applications configurées:
* faire un mvn clean install avec Maven
* soit faire:
  * lancer directement l'application avec mvn spring-boot:run
  * deployer directement dans votre IDE


