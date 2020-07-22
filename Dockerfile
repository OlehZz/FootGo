# Create and save war file
FROM maven:ibmjava-alpine as build

#create home directory
RUN mkdir /home/footgo && apk update && apk add git &&\
 git clone https://github.com/WiseHands/FootGo.git -b 'release/1.0.0' --single-branch /home/footgo && \
cp /home/footgo/src/main/resources/application.properties.example /home/footgo/src/main/resources/application.properties
WORKDIR /home/footgo
RUN mvn -f /home/footgo/pom.xml clean package && mv /home/footgo/target/ROOT.war\
 /home/footgo/footgov1.war
