call mvn -o compile
set MAVEN_OPTS=-noverify -javaagent:"D:\tools\jRebel\jrebel.jar" -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8088 -Xms256m -Xmx512m -XX:MaxPermSize=512m
call mvn tomcat7:run