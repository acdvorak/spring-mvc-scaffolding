Spring MVC Scaffolding
======================

Example [Spring MVC][spring-mvc] server that exposes a simple REST interface.

Requirements
============

*   [Maven][maven]

Uses
====

*   [Spring MVC][spring-mvc]
*   [Jetty][jetty]

Running
=======

IDE
---

The easiest way to run this project is to import it in [IntelliJ IDEA][intellij].

1.  Create a new "Maven" Run/Debug configuration
2.  Command line: ```jetty:run```

Command Line
------------

Simply run ```mvn clean jetty:run``` in your terminal.

Usage
=====

Once the server is running, open a REST client (e.g., [Postman][postman]) and try the following requests:

	GET     http://localhost:8080/test
	GET     http://localhost:8080/test/1
	POST    http://localhost:8080/test    {"id":5}
	PUT     http://localhost:8080/test/6  {"id":6}
	DELETE  http://localhost:8080/test/5

TODO
====

1.  Add [Hibernate][hibernate] integration
2.  Generate WAR/EAR file for Tomcat/WebLogic
3.  Add [Freemarker][freemarker]

[spring-mvc]: http://docs.spring.io/spring/docs/3.2.0.RELEASE/spring-framework-reference/html/mvc.html
[maven]: http://maven.apache.org/
[jetty]: http://www.eclipse.org/jetty/
[intellij]: http://www.jetbrains.com/idea/
[postman]: https://chrome.google.com/webstore/detail/postman-rest-client/fdmmgilgnpjigdojojpjoooidkmcomcm?hl=en
[hibernate]: http://hibernate.org/
[freemarker]: http://freemarker.org/
