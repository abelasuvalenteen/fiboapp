FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/abelasuvalenteen/fiboapp.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/fiboapp /app
RUN mvn clean verify sonar:sonar -Dsonar.projectKey=fiboapp -Dsonar.host.url=http://192.168.1.206:9000 -Dsonar.login=0aad4cbba098d789b17c0cc18fb10742c0e9c1f4
RUN mvn clean package

FROM openjdk:8-jre-alpine
ENV artifact fibonacci-1.0.0-SNAPSHOT.jar
WORKDIR /app
COPY --from=build /app/config.yml /app
COPY --from=build /app/target/${artifact} /app

ENTRYPOINT ["sh", "-c"]
CMD ["java -jar ${artifact} server config.yml"]
EXPOSE 8181
