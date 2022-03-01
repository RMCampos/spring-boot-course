#!/bin/bash

java -Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar target/mservices-0.0.1-SNAPSHOT.jar 
