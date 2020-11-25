From openjdk:8
copy ./target/cursomicros-0.0.1-SNAPSHOT.jar cursomicros-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "cursomicros-0.0.1-SNAPSHOT.jar"]