# biblio

Depot du projet  6 "Améliorez le système d’information de la bibliothèque" de la formation Expert JEE [formation Expert JEE](https://openclassrooms.com/fr/paths/99-expert-java-ee) OpenClassroom.

## Technologies utilisés:

### WebService 
* OpenJDk 11
* Maven 3.6.0
* Spring Boot 2.2.2
  * Security
  * Thymleaf
  * Web

### WebApp
* OpenJDk 11
* Maven 3.6.0
* Spring Boot 2.2.2
  * Security
  * Thymleaf
  * Web


## Configuration


#### Connexion a la BDD:

Dans le fichier : /WebService_biblio_p3/src/main/resources/hibernate.cfg.xml:
* connection-url:
L'adresse de votre BDD.*(rajouter si probleme de timezone aprés votre BDD: useSSL=false&amp;serverTimezone=UTC)*  
* connection.username:
Votre user.
* connection.password:
Le password de votre user

```java
        <property name="connection.url">votre BDD</property>
        <property name="connection.username">votre username</property>
        <property name="connection.password">votre password</property>
```
### WebApp<a name="configAppWebApp"></a>

#### Pour la gestion de tomcat:

Dans le fichier /WebApp_biblio_p3/src/main/resources/application.properties
* server.port:
Definir un port différent d'un port deja utilisé( ex: Glassfish)
```java
# tomcat
server.port= le port choisi pour votre App
```

## Déployement des Applications via IDE<a name="deployApp"></a>

Une fois la WebApp configuré:
* faire un mvn clean install avec Maven
* soit faire:
  * lancer directement l'application avec mvn spring-boot:run
  * deployer dans tomcat le war généré


