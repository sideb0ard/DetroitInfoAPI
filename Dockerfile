FROM google/debian:wheezy

RUN apt-get update && apt-get -y upgrade
RUN apt-get install -y openjdk-7-jre-headless

RUN mkdir /opt/detroitapi/
ADD target/scala-2.11/detroitapi-assembly-0.1.0-SNAPSHOT.jar /opt/detroitapi/djar.jar

EXPOSE 7777
CMD ["java", "-jar", "/opt/detroitapi/djar.jar"]


