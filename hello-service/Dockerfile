FROM java:8-jre
#MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD ./target/hello-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/hello-service.jar"]

EXPOSE 6000