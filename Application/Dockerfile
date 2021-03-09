#ENV LANG C.UTF-8
#ENV JAVA_HOME=/usr/lib/jvm/java-11-amazon-corretto

FROM mcr.microsoft.com/java/maven:11u10-zulu-debian10
COPY target/demo-0.0.1.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]
