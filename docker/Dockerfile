FROM amd64/openjdk:8-alpine
USER root
RUN apk update && apk add bash
COPY ./app /app
WORKDIR /app
CMD ./bin/text_service -Dhttp.port=80