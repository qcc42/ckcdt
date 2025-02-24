FROM  eclipse-temurin:17-jdk-focal
ADD target/ckcdt-1.0-SNAPSHOT-jar-with-dependencies.jar ckcdt-1.0-SNAPSHOT-jar-with-dependencies.jar 
ADD resources/prospects.txt /resources/prospects.txt
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ckcdt-1.0-SNAPSHOT-jar-with-dependencies.jar", "prospects.txt"]