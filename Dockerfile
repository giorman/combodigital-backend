FROM openjdk:11

VOLUME /tmp

EXPOSE 8001

ADD ./target/api-combodigital-0.0.1-SNAPSHOT.jar apicombodigital

ENTRYPOINT ["java", "-jar", "apicombodigital"]

