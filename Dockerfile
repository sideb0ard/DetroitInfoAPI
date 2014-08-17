FROM google/debian:wheezy

RUN apt-get update && apt-get -y upgrade
RUN apt-get install -y openjdk-7-jre-headless

RUN mkdir /opt/detroitapi/
ADD target/scala-2.10/detroitinfoapi-assembly-0.1.jar /opt/detroitapi/djar.jar

EXPOSE 8081
CMD ["java", "-jar", "/opt/detroitapi/djar.jar"]


