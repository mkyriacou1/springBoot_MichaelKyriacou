#Cats and Dogs Project

##High Level Summary of what is being used
- using spring security to protect app's web page and REST URLs (see p3.config.security.MyWebSecurityConfig)
- using Https SSL via self signed certificate
- implementing CommandLineRunner in a @Component to initialize Db (see p3.init.InitDb4dogs)
- spring MVC using thymeleaf as templating engine (see p3.mvc.MvcController and 
  src/main/resources/templates/*.html)
- using "thymeleaf security dialect" (see pom.xml and src/main/resources/templates.home.html)
- using Bootstrap for CSS in MVC views(html files) (see src/main/resources/templates/home.html)
- h2 as RDBMS
- lombok used to auto generated setter/getter/contructors
- creating REST api end points (resources) via Spring WebREST (see p3.rest.*)
- swagger (see exp17d.config.SwaggerConfig) used to generate document for REST api end points
- defining (part of) RDBMS schema via schema.sql of SpringBoot (see src/main/resources/schema.sql)
- updating RDBMS schema via JPA(hybernate) via "spring.jpa.hibernate.ddl-auto=update" value in application.properties
- initializing RDBMS schema via data.sql of SpringBoot (see src/main/resources/data.sql)
- using ORM(Object Relational Mapping) to access RDBMS (h2) via JPA (via it's default implementation, hybernate). 
- using jdbcTemplate to hand code access to RDBMS (h2) via SQL in code
- using JPA's JPQL Query and "Native" SQL Query

## Security
### authentication && authorization
- authentication is knowing who the user is. User is somehow able to prove who he is, 
  then he is authenticated. Authentication can be done via user providing correct username/password 
  or user providing a verifiable "token"(like JWT)
- authorization is allowing an authenticated user to access a feature or data
- see p3.config.security.MyWebSecurityConfiguerAdapter 
 - Creates the authentication and authorization
 - Creates usernames/passwords, the roles and authorities
 - Protects Web and Rest resources
- see p3.config.security.HTTPsSSLConfig4tomcat 
 - makes the URL secure
 - redirrects Http 8888 to Https 8889

### roles && permissions(authorities)
- permissions is fine granular, specifies what user is allowed to access/do. Permissions 
  is also called "authorities"
- roles is coarse, typically specifies a range of things user is allowed to access/do
- usually roles contains permissions
- Roles include catMaster, dogMaster, admin, and Developer
- Authorities include haveDogs

## generating "Self Signed" "SSL Certificate" to use with Https
- Keytool was used to generate a self signed ssl certificate
- This is found in src/main/resources/certificates4https/p3.p12

## using jdbctTemplate for DAO(Data Access Object) to RDBMS
- see p3.jdbctemplate.dao.CatDAOImpl
- see p3.jdbctemplate.dao.catDAO
- see p3.jdbctemplate.dao.JpaRepository

## using JPA to access RDBMS
- see p3.jpa.model.Dog for "Entity" class
- see p3.jpa.repo.DogRepository for repo interface which guides repo impl generation 
  via JPA


## using lombok to instrument(auto generate) getter/setter/constructor/toString/.. methods 
in a class via lombok annotations
- see p3.jdbctemplate.model.Cat
- see p3.jdbctemplate.model.CatRowMapper
- see p3.jpa.model.Dog

## creating REST webservice api end points(resources)
- see p3.rest.CatRestController
- see p3.rest.DogRestController

##Using Thymeleaf
- see p3.mvc.MvcController 
 - Allows access to Urls such as /dogs,/cats/admin, etc.
- see src/main/resources/templates/*.html)
 - Templates for all the pages

## swagger summary
- swagger is a "specification"
- it can be applied in many languages/frameworks
- springfox is a "spring" "implementation" of swagger
- swagger is one of the ways, in fact basically an industry standard, to generate (REST) 
  API documentation
- see p3.config.Swagger

## TO access H2
- type localhost:8889/h2-console 
 - Must be logged in as Admin


