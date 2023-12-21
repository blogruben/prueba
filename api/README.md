# Albums

# Requisitos
- Docker
- JDK 17 

# Configuracion inicial
https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.2.0&packaging=war&jvmVersion=17&groupId=com.typicode&artifactId=jsonplaceholder&name=jsonplaceholder&description=Api%20Rest&packageName=com.typicode.jsonplaceholder&dependencies=data-jpa,h2,web,devtools

# Inicializar
//esto descarga JDK17 en caso de existir.
gradlew build;
gradlew bootRun;

docker build -t api .   
docker run -dp 8080:8080 api
docker logs -f api


# BBDD
Aceder http://localhost:8080/h2-ui/
INSERT INTO USUARIO VALUES(1, 'nombre','email',5);
INSERT INTO USUARIO VALUES(2, 'nombre','email',5);
select * from USUARIO;

# Test de integracion
GET  http://localhost:8080/usuario/1
     {"id":1,"nombre":"email","email":"nombre","prioridad":5}

GET   http://localhost:8080/
[{"id":1,"nombre":"email","email":"nombre","prioridad":5},{"id":2,"nombre":"email","email":"nombre","prioridad":5}]

POST  localhost:8080/usuario
body-raw {"id":3,"nombre":"email","email":"nombre","prioridad":5}
