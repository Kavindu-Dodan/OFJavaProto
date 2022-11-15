FROM adoptopenjdk/openjdk11:slim

ARG APP_NAME=OFJBootApp.jar

WORKDIR /OFJ
COPY ./build/libs/$APP_NAME .

RUN adduser nonroot --uid 65535 --disabled-password
RUN chown -R nonroot:nonroot /OFJ
USER nonroot

CMD java -jar OFJBootApp.jar
