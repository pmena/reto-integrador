FROM openjdk:11-jre
COPY target/Reto-integrador*.jar /opt/app.jar
ENTRYPOINT ["java","-jar","/opt/app.jar"]