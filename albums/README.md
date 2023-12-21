# Albums


# Requisitos 
Se requiere Docker.
El proyecto esta desarrollado en SpringBoot Gradle 8.5 y JDK 17 pero no
son un requisito, ya que usamos el wrapper de gradle y se descarga automaticamente 
temurin-JDK 17.


# Configuracion inicial
https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.2.0&packaging=war&jvmVersion=17&groupId=com.typicode&artifactId=jsonplaceholder&name=jsonplaceholder&description=Api%20Rest&packageName=com.typicode.jsonplaceholder&dependencies=data-jpa,h2,web,devtools


# Inicializar
```
//esto descarga JDK17 en caso de existir.
gradlew build;

docker build -t getting-started .
docker run -dp 8080:8080 getting-started
```





