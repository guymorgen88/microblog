FROM java:8

ADD target/microblog-spring-boot.jar microblog-spring-boot.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "microblog-spring-boot.jar"]