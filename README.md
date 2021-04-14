HelloWorld Servlet example
=====================================
###### Deploy
```shell
mvn clean install wildfly:deploy
```
###### Test
```shell
http://localhost:8080/jboss-tester/call
http://onland-app-test-onland-csp-dev-2.apps.mssocp4uat.corp.teranet.ca/jboss-tester/call
```
Make sure truststore in the ocp env already mounted and does exist otherwise ldap wouldn't work (jtruststore or equivalent)
