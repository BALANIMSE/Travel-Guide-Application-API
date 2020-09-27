FROM java:8
WORKDIR /
ADD target/TravelerGuideServices-1.0.0.jar //
EXPOSE 8082
ENTRYPOINT ["java","-jar","/TravelerGuideServices-1.0.0.jar"]