# Expense tracking application
This project serves as a learning ground for me. I am trying to get myself familiar with the following technologies:

## Goals
1. Gradle: especially the multi-project feature
2. Spring Data
3. Spring Data REST 
4. [React](https://reactjs.org/) for Spring Boot project, link [here](https://developer.okta.com/blog/2018/07/19/simple-crud-react-and-spring-boot) 
5. JUnit 5 with Spring
6. [Spring Security](https://spring.io/projects/spring-security#learn) with [OAuth support](https://spring.io/projects/spring-security-oauth)

## Stretch goals
These are goals that I would like to achieve. However, they are deemed nice-to-have goals as they do not contribute to my learning for the time being.

1. Setup and use [HashiCorp Vault](https://www.vaultproject.io/) in my project, with the help of [Spring Vault](https://docs.spring.io/spring-vault/docs/current/reference/html/index.html)
2. Setup [Spring Cloud Config](https://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.1.0.RELEASE/single/spring-cloud-config.html) so that all my projects get the configuration from a common place. This is very useful for my integration-api project at work as well.
3. [Spring Rest Docs](https://spring.io/projects/spring-restdocs) to document my REST APIs

Another goal is to learn React as the same time. However, this is  stretch goal. 

## Progress
So far, I have got the following working

#### Setup PostgreSQL database

  :ballot_box_with_check: Having a springbootdb database 
  
  :ballot_box_with_check: Setup [uuid-ossp](https://www.postgresql.org/docs/current/uuid-ossp.html) extension which allows UUID to be generated, based on this [instruction](https://www.postgresql.org/message-id/C5EBF511-835E-4F24-A4E4-6CC0119F48E4@me.com)
  
  :ballot_box_with_check: Verifying it works with the app
  
  :black_square_button: Setup correct index for the tables
  
#### Setup Gradle for my project
Gradle is my company official build tool. It makes sense that I should at least be familiar with it.

  :ballot_box_with_check: Gradle multi-project approach

  :ballot_box_with_check: Setup inter-project dependencies

  :ballot_box_with_check: Setup common build scripts in parent project.

#### Setup data access layer using Spring Data JPA
This is a very well known Spring project. It is necessary for me to know about it. I don't have to know it inside out. However, I have to know enough to be able to use it effectively.   
 
  :ballot_box_with_check: Setup entity and repositories classes
  
  :ballot_box_with_check: Setup a common data layer that other projects can use, based on this [instruction](https://stackoverflow.com/questions/55728878/scan-repositories-in-another-package)
  
  :ballot_box_with_check: Verified that the data can be saved/retrieved from PostgreSQL database
  
  :black_square_button: Audit entity classes to make sure they follow good practice for JPA

#### Setup Flyway
This is a tool to manage different versions of the database migration script. This is very useful to ensure that the code that you work with is applicable to the database schema.
  
  :ballot_box_with_check: Add Flyway support for my project with the help of this [link](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html#howto-execute-flyway-database-migrations-on-startup)
  
  :ballot_box_with_check: Created migration scripts for the project
  
  :black_square_button: Create repeatable migration scripts. The reason is because I find that I keep having to drop and create database whenever I changed my schema. I will use this [link](https://flywaydb.org/documentation/migrations#repeatable-migrations) to help me.    
  
#### Setup REST endpoint with Spring Data REST
Spring Data REST generates REST endpoints for `@Repository` classes automatically. This saves from having to write `@RestController` classes by hand.

  :ballot_box_with_check: Setup the endpoints for all the available repositories
  
  :black_square_button: Configure the JSON response so that it helps me to work with the response effectively. The current default JSON response (HAL based) is not very intuitive to work with. 