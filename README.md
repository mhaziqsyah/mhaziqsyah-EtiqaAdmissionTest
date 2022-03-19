# mhaziqsyah & anisMegat-EtiqaAdmissionTest
Web services for school system

# Description 
Assessment:

Develop RESTful Web Services using any Spring (Spring 4 and above/Spring Boot 2).
Add exception handling, null/error checking. If you find it necessary.
Add on with “good-to-have” and ”nice-to-have” features.
Import and push the source codes to github. Including the dump/SQL files for your database.
Make sure the source codes is compile-able without external libraries or jar files attached. (Hint: Maven, Gradle)

Situation:

A school need to create web services for their system in order for them to work cross platforms.
The school most important module is student module.
Develop get, add, update and delete RESTful Web Services for student module. (CRUD Modules)
Add additional web service that get student/s by course ID.
Integrate the web services with websites.
Data displayed in the websites must be taken from web services using javascript.
You may use datatables.js at your disposal.

## Getting Started

### Dependencies

* OS version: Windows 10
* Docker

### Installing

* Docker Download
https://www.docker.com/products/docker-desktop/


### Executing program

* How to run the program
* Using GitBash run this command
* Install NPM Dependencies
```
NPM Install
```
* Start the Program
 ```
yarn start
```
* Database setup
* Run Powershell terminal
* Check Docker Version
 ```
docker --v
```
* Create Database in Docker
 ```
docker run --name mysqldb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=EtiqaTest -d -p 3306:3306 mysql
```

* Run Springboot Application

# Authors 

1. Haziq Syahmi
2. Puteri Anis
