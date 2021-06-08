# Spring_Boot_Exercises - Tutorial Urls and Solutions to various build related issues

# Spring rest with json
-https://mkyong.com/spring-mvc/spring-3-mvc-and-json-example/

# mvc
http://gurugubellitech.blogspot.com/2018/02/employee-management-app-java-jsp-jstl-spring-mysqal-jquery-ajax.html

# global-error-handling-example-in-spring-boot
https://www.netsurfingzone.com/spring-boot/exceptionhandler-example-in-spring-boot/

# jwt,docker,kafka 
https://www.javainuse.com/spring/boot-jwt
https://www.javainuse.com/devOps/docker/docker-war
https://www.javainuse.com/spring/boot_swagger https://www.javainuse.com/spring/spring-boot-apache-kafka-hello-world

# hibernate-validator-constraints-using-spring-boot
https://www.netsurfingzone.com/hibernate/hibernate-validator-constraints-example-using-spring-boot/

# db - crud 
https://www.netsurfingzone.com/spring-boot/spring-boot-crud-example-with-mysql/ https://www.javainuse.com/spring/SpringBoot_DataJPA https://dev.to/reytech-lesson/create-and-view-employee-using-jpa-springboot-and-thymeleaf-4mme https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html

# db -mappings
https://www.netsurfingzone.com/jpa/difference-between-crudrepository-and-jparepository-in-spring-data-jpa/ https://www.netsurfingzone.com/hibernate/one-to-one-bidirectional-mapping-example-in-hibernate-jpa-using-spring-boot-and-oracle/

# count - jpa
https://www.netsurfingzone.com/jpa/spring-data-jpa-crudrepository-count-example/

# Solutions to various build related issues

  Failure to transfer org.apache.maven:maven-archiver:pom:2.5(build error) 
1.Remove all your failed downloads:
  cd %userprofile%\.m2\repository
  for /r %i in (*.lastUpdated) do del %i
2.Go back into Eclipse, Right-click on the project and select Maven > Update Project. > Select "Force Update of Snapshots/Releases".

#You can specify a class path to use when you run javac.exe as follows:
d:\javadev> javac -classpath ".;d:\Program Files\Apache Group\ jakarta-tomcat-3.2.3\lib\servlet.jar" MyServlet.java

# reference
https://stackoverflow.com/questions/9193228/compile-error-package-javax-servlet-does-not-exist
