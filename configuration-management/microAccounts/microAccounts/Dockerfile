
# starting with a base image
# openjdk:17-jdk-slim is the base image
#Start with a base image containing Java runtime
# this is one dipemdancy which is open jdk
FROM openjdk:21-jdk-slim

# MAINTAINER instruction is deprecated in favor of using label
# MAINTAINER microBank.com
#Information around who maintains the image
LABEL maintainer="microBank.com"


#this is the second dipendancy which is the microAccounts jar
COPY target/microAccounts-0.0.1-SNAPSHOT.jar microAccounts-0.0.1-SNAPSHOT.jar


# exicuting the application
ENTRYPOINT ["java","-jar","microAccounts-0.0.1-SNAPSHOT.jar"]