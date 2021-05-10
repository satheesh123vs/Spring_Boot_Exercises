# Spring_Boot_Exercises
Spring_Boot_examples



#Failure to transfer org.apache.maven:maven-archiver:pom:2.5(build error) 
1.Remove all your failed downloads:
  cd %userprofile%\.m2\repository
  for /r %i in (*.lastUpdated) do del %i
2.Go back into Eclipse, Right-click on the project and select Maven > Update Project. > Select "Force Update of Snapshots/Releases".

#You can specify a class path to use when you run javac.exe as follows:
d:\javadev> javac -classpath ".;d:\Program Files\Apache Group\ jakarta-tomcat-3.2.3\lib\servlet.jar" MyServlet.java

#reference
https://stackoverflow.com/questions/9193228/compile-error-package-javax-servlet-does-not-exist
