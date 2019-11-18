## IFI - TP 3 - pokemon-type-api-v2 with springs framework

### Thi-Ngoc-Anh TRAN, M2-E-Service, Université de Lille

https://juwit.github.io/ifi-2019/cours/03-spring/03-tp-spring.html

#### 1. Configuration de Java 12 sur les postes de l’université
Modifier le fichier ~/.bashrc pour y ajouter les lignes suivantes :

> export JAVA_HOME=/usr/lib/jvm/jdk-12.0.1

> export PATH=$JAVA_HOME/bin:$PATH

### 2. Config url :
Dans config de tomcat : deployement -> application context : mettre /

### 3. Pré-requise : 
- java : version >= 12
- maven : version >= 2

### 4. Execution
- Pour exécuter l'application, dans le terminal :

    > mvn spring-boot:run

- Pour générer et exécuter un package .jar, dans le terminal :

    > mvn package spring-boot:repackage

    ensuite exécuter le .jar par la commande (le nom du .jar dépend du nom artifactId déclaré dans pom.xml):

    > java -jar target/pokemon-v2-atr-0.1.0.jar

- Essayer les URLs suivants dans un navigateur (chrome, firefox, ...):
    + http://localhost:8080/pokemon-types/
    + http://localhost:8080/pokemon-types/5
    + http://localhost:8080/pokemon-types/?name=mew
    + http://localhost:8080/pokemon-types/?types=bug,poison