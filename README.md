# JPA Inheritance types showcase

A small spring Boot project which showcases jpa inheritance types

Each type is showcased per branch: 
 - single table
 - joined table
 - per class table 

Here's a list of default env vars I used, and are configured in the project.
You can also use yours but make sure you do the necessary changes in the `application.properties` file config in the classpath,
as well as updating `schema` value in all codebase occurrences.

For example:

```java
@Table(name = "EMPLOYEE", schema = "jpa_test_db_schema") //update schema
public abstract class Employee {
    //...
}
```
 

> POSTGRES_DB_SCHEMA=jpa_test_db_schema
> 
> POSTGRES_USER=postgres
> 
> POSTGRES_PASSWORD=postgres
> 
> POSTGRES_DB=jpa_test_db
> 
> POSTGRES_PORT=5432
> 
> POSTGRES_URL=jdbc:postgresql://localhost:${POSTGRES_PORT}/${POSTGRES_DB}
