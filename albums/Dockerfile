FROM tomcat:8-jdk8-corretto
LABEL maintainer="ruben"
ADD app.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]

