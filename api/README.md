# Albums

# Requisitos
Se requiere Docker. El proyecto esta desarrollado en SpringBoot Gradle 8.5 y JDK 17 pero no son un requisito, ya que usamos el wrapper de gradle y se descarga automaticamente temurin-JDK 17.

# Configuracion inicial
https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.2.0&packaging=war&jvmVersion=17&groupId=com.typicode&artifactId=jsonplaceholder&name=jsonplaceholder&description=Api%20Rest&packageName=com.typicode.jsonplaceholder&dependencies=data-jpa,h2,web,devtools

# Inicializar
//esto descarga JDK17 en caso de existir.
gradlew build;
gradlew bootRun;

docker build -t api .   
docker run -dp 8080:8080 api
docker logs -f api

INSERT INTO USUARIO VALUES(1, 'nombre','email',5);
INSERT INTO USUARIO VALUES(2, 'nombre','email',5);
select * from USUARIO;

http://localhost:8080/usuario/1


