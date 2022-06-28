# acme store rest service 

## Pre-reqs

Have a mongodb instance or use docker: 

1. Run MongoDB using docker: 
	* `docker run -d --name mongodb-instance -p 27017:27017 mongo`

## Introduction

MicroProfile Starter has generated this MicroProfile application for you.

The generation of the executable jar file can be performed by issuing the following command

```shell
mvn clean package
``

This will create an executable jar file **acme-store-rest-nosql.jar** within the _target_ maven folder. This can be started by executing the following command

```shell
java -jar target/acme-store-rest-nosql.jar
```

To launch the test page, open your browser at the following URL

```shell
http://localhost:8081/index.html  
```


