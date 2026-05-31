# OpenXava Final Project

Base Maven project scaffold for OpenXava.

## Structure

- `src/main/java` for entities and application code.
- `src/main/resources/META-INF/persistence.xml` for JPA configuration.
- `src/main/resources/xava.properties` for OpenXava settings.
- `src/main/webapp` for the web layer and deployment descriptors.

## Run

Build the project with:

```bash
mvn clean package
```

Deploy the generated WAR to a Tomcat 9 runtime or another servlet container that supports the `javax.servlet` API.

## Notes

The project starts with an embedded HSQLDB persistence configuration so it is self-contained. You can switch `persistence.xml` to a container-managed datasource later if you want a Tomcat JNDI setup.