##JSP Servlets Demo APP
  This project contains demo implementation of JSP and Servlets. In this project we've used <code>Student.class</code> as a examplary model to test it's capabilities.
  
##How to use, what can it do?
  This project allows user to manage <code>Student.class</code> entities in database using JSP as view and Servlets as Backend controllers and services. You can either add, delete, list or modify entities state in the database.
  
  You should provide Your own database configuration in the `hibernate.cfg.xml` file.
  
 ##How to build
  Prerequisites of this project are:
  
  - maven
  - java (min version 8)
  - mysql database (minimum version 5.7)
  - tomcat server or any equivalent
  
  You can build this project using command:
  
  `$ mvn package`
  
  Which will generate `*.war` file in the `target` folder.
  
  ##How to run?
  You can run this Web Archive file (generated by the `mvn package` command) in the container such as:
  
  - tomcat
  - glassfish
  - wildfly
  
  ##What can be improved
  My experience
  
  ###Author
  Dorota Potulska