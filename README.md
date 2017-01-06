# admin

To run the project we use maven

We are going to change the pure wildfly project into a springboot project now

mvn package
mvn wildfly:run

this will download the wildfly system for you if you do not have one. If you have a wildfly system then you can change the pom
and wildfly plugin definition to reflect where your wildfly is.

You can connect to the server using http://localhost:8778 and you will be presented with a landing page, click the link and you will be
presented with a mock up of the dashboard.

I have added security and a login page at the moment but the validation is hardcoded to admin/admin at the moment. After all this
is just a demo system.

We have a controller class that use JAX-RS annotations to specifiy which URIs to process. We then use thymeleaf to act as the view generator
along with html templates found in WEB-INF/templates folder.

We use JPA to connect to the database which is defined via a JNDI lookup. In fact we use the ExampleDS H2 database shipped with wildfly for now.
If we were using spring-data their repository concepts are very good but as we are not using spring at all I want to see if we can 
provide a fairly simple approach to the entity objects. Some of this might depend oon the type of entities and queries likely to be invoked 
by the dashboard.

I have created a DashboardApplication that runs once at the startup of the application and inits the database.
I also have a single RESTApplication that defines the "/app" context for RESTEasy processing of the JAX-RS annotations
