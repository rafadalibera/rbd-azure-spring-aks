FROM mcr.microsoft.com/java/maven:11u10-zulu-debian10

ENV APPLICATIONINSIGHTS_CONNECTION_STRING = ""

COPY target/demo-0.0.1.jar demo.jar
COPY bin/applicationinsights-agent-3.0.2.jar applicationinsights-agent-3.0.2.jar

ENTRYPOINT ["java", "-javaagent:/applicationinsights-agent-3.0.2.jar", "-jar", "/demo.jar"]
