FROM openjdk:11.0.9.1-jre-buster

COPY build/libs/*.jar /app/app.jar

HEALTHCHECK --interval=60s \
            --timeout=5s \
            --start-period=30s \
            CMD curl --fail http://localhost:8080 || exit 1

EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]