# builder image
FROM amazoncorretto:17-al2-jdk AS builder

RUN mkdir /devops-main
WORKDIR /devops-main

COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean bootJar

# runtime image
FROM amazoncorretto:17.0.12-al2

ENV TZ=Asia/Seoul
ENV PROFILE=${PROFILE}

RUN mkdir /devops-main
WORKDIR /devops-main

COPY --from=builder /devops-main/build/libs/devops-main-* /devops-main/app.jar

CMD ["sh", "-c", " \
    java -Dspring.profiles.active=${PROFILE} \
         -jar /devops-main/app.jar"]
