FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/abelasuvalenteen/fibonacci.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/fibonacci /app
RUN mvn clean package

FROM openjdk:8-jre-alpine
ENV artifact fibonacci-1.0.0-SNAPSHOT.jar
WORKDIR /app
COPY --from=build /app/config.yml /app
COPY --from=build /app/target/${artifact} /app

ENTRYPOINT ["sh", "-c"]
CMD ["java -jar ${artifact} server config.yml"]
EXPOSE 8181