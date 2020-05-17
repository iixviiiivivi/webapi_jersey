# webapi_jersey
Java Maven Project / Web API / Jersey

## Introduction
1.  Java Maven: Jersey
* Group Id: org.glassfish.jersey.archtypes
* Artifact Id: jersey-quickstart-webapp
2.  Hibernate
* Maven Repository Search: Hibernate Core Relocation
* https://mvnrepository.com/artifact/org.hibernate/hibernate-core
3.  Validation
* Maven Repository Search: Hibernate Validator Engine
* https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator
* Keywords: @Valid @NULL @Pattern...etc
4.  Exception
* create Error.java extend RuntimeException
* create ErrorMapping.java implements ExceptionMapping<Error> to catch specific exception
* create another GlobalMappping.java implements ExceptionMapping<Throwable> to catch all unhandled exceptions
5.  SQL Server
* use member_table.sql to generate data in SQL Server
