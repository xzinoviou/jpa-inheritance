# JPA Inheritance types showcase

A small spring Boot project which showcases jpa inheritance types

Each type is showcased per branch: 
 - single table
 - joined table
 - per class table 

You can use the env vars supplied in the .env file , and are already configured in the project.
Alternatively, you can also use yours but make sure you do the necessary changes in the `application.properties` file config in the classpath,
as well as updating `schema` value in all codebase occurrences.

For example:

```java
@Table(name = "EMPLOYEE", schema = "jpa_test_db_schema") //update schema
public abstract class Employee {
    //...
}
```
