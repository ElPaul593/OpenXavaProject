# OpenXava Final Project

Base Maven project scaffold for OpenXava.

## Structure

- `src/main/java` for entities and application code.
- `src/main/resources/META-INF/persistence.xml` for JPA configuration.
- `src/main/resources/xava.properties` for OpenXava settings.
- `src/main/webapp` for the web layer and deployment descriptors.

## Run

Run the project with:

```bash
mvn spring-boot:run
```

If you only want the deployable WAR, build it with:

```bash
mvn clean package
```

Spring Boot 2.7.18 provides the embedded servlet container used for local execution, while OpenXava remains at version 7.7.2.

## Notes

The project starts with an embedded HSQLDB persistence configuration so it is self-contained. You can switch `persistence.xml` to a container-managed datasource later if you want a Tomcat JNDI setup.